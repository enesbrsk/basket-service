package com.service.basket.repository;

import com.service.basket.model.ProfileInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileInformationRepository extends JpaRepository<ProfileInformation,Long> {
}
