package com.service.englishdise.dto.response;

import com.service.englishdise.enums.Country;
import com.service.englishdise.enums.EnglishLevel;
import com.service.englishdise.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProfileResponse {
    private String name;
    private String aboutMe;
    private String image;
    private String nativeLanguage;
    private EnglishLevel englishLevel;
    private Gender gender;
    private int age;
    private Country country;
    private Long userId;
}
