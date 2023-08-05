package com.service.englishdise.service;

import com.service.englishdise.dto.UserDto;
import com.service.englishdise.dto.converter.ProfileMapper;
import com.service.englishdise.dto.request.ProfileRequest;
import com.service.englishdise.dto.response.ProfileResponse;
import com.service.englishdise.enums.MatchStatus;
import com.service.englishdise.model.Matcher;
import com.service.englishdise.model.Profile;
import com.service.englishdise.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserService userService;

    public ProfileService(ProfileRepository profileRepository, UserService userService) {
        this.profileRepository = profileRepository;
        this.userService = userService;
    }

    public void createProfile(ProfileRequest profileRequest){
        UserDto userDto = userService.findUserInContext();
        Profile profile = ProfileMapper.toProfile(profileRequest,userDto.getId());
        profileRepository.save(profile);
    }

    public List<ProfileResponse> getAllProfile(){
        return profileRepository.findAll()
                .stream()
                .map(ProfileMapper::toProfileResponse)
                .collect(Collectors.toList());
    }


}
