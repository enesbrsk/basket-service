package com.service.englishdise.service;

import com.service.englishdise.dto.converter.ProfileMapper;
import com.service.englishdise.dto.request.ProfileRequest;
import com.service.englishdise.dto.response.ProfileResponse;
import com.service.englishdise.model.Profile;
import com.service.englishdise.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public void createProfile(ProfileRequest profileRequest){
        Profile profile = ProfileMapper.toProfile(profileRequest);
        profileRepository.save(profile);
    }

    public List<ProfileResponse> getAllProfile(){
        return profileRepository.findAll()
                .stream()
                .map(ProfileMapper::toProfileResponse)
                .collect(Collectors.toList());
    }

}
