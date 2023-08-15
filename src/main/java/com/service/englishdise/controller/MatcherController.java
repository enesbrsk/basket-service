package com.service.englishdise.controller;

import com.service.englishdise.dto.response.ProfileResponse;
import com.service.englishdise.service.MatcherService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/matcher")
public class MatcherController {

    private final MatcherService matcherService;

    public MatcherController(MatcherService matcherService) {
        this.matcherService = matcherService;
    }

    @PostMapping
    public void createMatch(@RequestParam(value = "matchedUserId") Long matchedUserId){
        matcherService.createMatch(matchedUserId);
    }

    @GetMapping("/find")
    public ResponseEntity<List<ProfileResponse>> getFindMatch(){
        return ResponseEntity.ok(matcherService.getFindMatch());
    }

    @GetMapping("/accepted")
    public ResponseEntity<List<ProfileResponse>> getAcceptedMatch(){
        return ResponseEntity.ok(matcherService.getAcceptedMatch());
    }

}
