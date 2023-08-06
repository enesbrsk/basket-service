package com.service.englishdise.repository;

import com.service.englishdise.dto.response.ProfileResponse;
import com.service.englishdise.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
    List<Profile> findByUserIdNot(Long userId);
}
