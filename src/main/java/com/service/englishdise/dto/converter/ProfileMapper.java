package com.service.englishdise.dto.converter;

import com.service.englishdise.dto.request.ProfileRequest;
import com.service.englishdise.dto.response.ProfileResponse;
import com.service.englishdise.model.Profile;
import org.springframework.stereotype.Component;

@Component
public class ProfileMapper {

    public static Profile toProfile(ProfileRequest request) {
        Profile profile = Profile.builder()
                .name(request.getName())
                .aboutMe(request.getAboutMe())
                .image(request.getImage())
                .nativeLanguage(request.getNativeLanguage())
                .englishLevel(request.getEnglishLevel())
                .gender(request.getGender())
                .age(request.getAge())
                .country(request.getCountry())
                .build();

        return profile;
    }

    public static ProfileResponse toProfileResponse(Profile request) {
        ProfileResponse profileResponse = ProfileResponse.builder()
                .name(request.getName())
                .aboutMe(request.getAboutMe())
                .image(request.getImage())
                .nativeLanguage(request.getNativeLanguage())
                .englishLevel(request.getEnglishLevel())
                .gender(request.getGender())
                .age(request.getAge())
                .country(request.getCountry())
                .build();

        return profileResponse;
    }

}
