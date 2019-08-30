package com.huaxi.scoring.center.repository;

import com.huaxi.scoring.center.domain.Score;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Score Repository 接口.
 */
public interface ScoreRepository extends JpaRepository<Score, Long>{
    Page<Score> findByCompanyNameLike(String scoreName, Pageable pageable);

    Score findByCompanyName(String scoreName);
}
