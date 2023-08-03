package com.service.englishdise.dto.request;

import com.service.englishdise.enums.Country;
import com.service.englishdise.enums.EnglishLevel;
import com.service.englishdise.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProfileRequest {
    private String name;
    private String aboutMe;
    private String image;
    private String nativeLanguage;
    private EnglishLevel englishLevel;
    private Gender gender;
    private int age;
    private Country country;
}
