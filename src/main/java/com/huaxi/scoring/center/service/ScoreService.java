package com.huaxi.scoring.center.service;

import com.huaxi.scoring.center.domain.Project;
import com.huaxi.scoring.center.domain.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ScoreService {
     Score saveOrUpateScore(Score score);

    Score registerScore(Score score);

    void removeScore(Long id);

    Optional<Score> getScoreById(Long id);

    Page<Score> listUsersByCompanyNameLike(String Score, Pageable pageable);

    /**
    * 查找所有竞标项目
    */
    List<Score> findAllScores();

    Page<Score> findAllScoresForPage(Pageable pageable);
}