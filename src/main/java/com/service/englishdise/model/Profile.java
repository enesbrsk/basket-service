package com.service.englishdise.model;

import com.service.englishdise.enums.Country;
import com.service.englishdise.enums.EnglishLevel;
import com.service.englishdise.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Profile extends BaseEntity{
    private String name;
    private String aboutMe;
    private String image;
    private String nativeLanguage;
    @Enumerated(EnumType.STRING)
    private EnglishLevel englishLevel;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private int age;
    @Enumerated(EnumType.STRING)
    private Country country;
    private Long userId;

    @OneToMany(mappedBy = "profile",cascade = CascadeType.ALL)
    private List<Feedback> feedbackList;
}
