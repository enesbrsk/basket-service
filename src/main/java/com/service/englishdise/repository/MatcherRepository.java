package com.service.englishdise.repository;

import com.service.englishdise.enums.MatchStatus;
import com.service.englishdise.model.Matcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatcherRepository extends JpaRepository<Matcher,Long> {
    List<Matcher> findByMatchedUserIdAndMatchStatus(Long id, MatchStatus matchStatus);
    List<Matcher> findByUserIdAndMatchStatus(Long userId,MatchStatus matchStatus);
}
