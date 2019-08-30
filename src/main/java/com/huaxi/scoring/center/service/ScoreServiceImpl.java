package com.huaxi.scoring.center.service;

import com.huaxi.scoring.center.domain.Score;
import com.huaxi.scoring.center.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	@Override
	public Score saveOrUpateScore(Score score) {
		return scoreRepository.save(score);
	}

	@Transactional
	@Override
	public Score registerScore(Score score) {
		return scoreRepository.save(score);
	}

	@Transactional
	@Override
	public void removeScore(Long id) {
		scoreRepository.deleteById(id);
	}

	@Override
	public Optional<Score> getScoreById(Long id) {
		return scoreRepository.findById(id);
	}

	@Override
	public Page<Score> listUsersByCompanyNameLike(String score, Pageable pageable) {
        // 模糊查询
		score = "%" + score + "%";
        Page<Score> material = scoreRepository.findByCompanyNameLike(score, pageable);
        return material;
	}

	@Override
	public List<Score> findAllScores() {
		List<Score> scoreList = scoreRepository.findAll();
		return scoreList;
	}

	@Override
	public Page<Score> findAllScoresForPage(Pageable pageable) {
		Page<Score> sores = scoreRepository.findAll(pageable);
		return sores;
	}

}
