package com.service.englishdise.service;

import com.service.englishdise.dto.UserDto;
import com.service.englishdise.dto.converter.ProfileMapper;
import com.service.englishdise.dto.request.ProfileRequest;
import com.service.englishdise.dto.response.ProfileResponse;
import com.service.englishdise.enums.MatchStatus;
import com.service.englishdise.model.Matcher;
import com.service.englishdise.model.Profile;
import com.service.englishdise.repository.ProfileRepository;
import com.service.englishdise.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    public ProfileService(ProfileRepository profileRepository, UserService userService,
                          UserRepository userRepository) {
        this.profileRepository = profileRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    public void createProfile(ProfileRequest profileRequest) {
        UserDto userDto = userService.findUserInContext();
        Profile profile = ProfileMapper.toProfile(profileRequest, userDto.getId());
        profileRepository.save(profile);
    }

    public List<ProfileResponse> getAllProfile() {
        return profileRepository.findAll()
                .stream()
                .map(ProfileMapper::toProfileResponse)
                .collect(Collectors.toList());
    }

    public List<ProfileResponse> getAllProfileNotUserId(){
        UserDto userDto = userService.findUserInContext();
        return profileRepository.findByUserIdNot(userDto.getId())
                .stream()
                .map(ProfileMapper::toProfileResponse)
                .collect(Collectors.toList());
    }

    public List<ProfileResponse> getProfileById(Long id) {
        return profileRepository.findById(id).stream()
                .map(ProfileMapper::toProfileResponse)
                .collect(Collectors.toList());
    }


}
