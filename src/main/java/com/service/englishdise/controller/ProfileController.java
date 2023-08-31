package com.service.englishdise.controller;

import com.service.englishdise.dto.request.ProfileRequest;
import com.service.englishdise.dto.response.ProfileResponse;
import com.service.englishdise.service.ProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public void createProfile(@RequestBody ProfileRequest profileRequest){
        profileService.createProfile(profileRequest);
    }

    @GetMapping
    private ResponseEntity<List<ProfileResponse>> getAllProfile(){
        return ResponseEntity.ok(profileService.getAllProfile());
    }

}
