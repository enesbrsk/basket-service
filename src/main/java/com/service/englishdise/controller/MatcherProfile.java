package com.service.englishdise.controller;

import com.service.englishdise.service.MatcherService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/matcher")
public class MatcherProfile {

    private final MatcherService matcherService;

    public MatcherProfile(MatcherService matcherService) {
        this.matcherService = matcherService;
    }

    @PostMapping
    public void createMatch(@RequestParam(value = "matchedUserId") Long matchedUserId){
        matcherService.createMatch(matchedUserId);
    }
}
