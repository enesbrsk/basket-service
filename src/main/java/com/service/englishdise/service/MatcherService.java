package com.service.englishdise.service;

import com.service.englishdise.dto.UserDto;
import com.service.englishdise.enums.MatchStatus;
import com.service.englishdise.model.Matcher;
import com.service.englishdise.repository.MatcherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MatcherService {

    private final MatcherRepository matcherRepository;
    private final UserService userService;

    public MatcherService(MatcherRepository matcherRepository, UserService userService) {
        this.matcherRepository = matcherRepository;
        this.userService = userService;
    }

    public void createMatch(Long matchedUserId){
        UserDto userDto = userService.findUserInContext();
        final List<Matcher> pendingMatches = matcherRepository.findByMatchedUserId(userDto.getId());

        if (!pendingMatches.isEmpty()){
            for (Matcher match : pendingMatches){
                if (match.getMatchedUserId().equals(userDto.getId())){
                    match.setMatchStatus(MatchStatus.ACCEPTED);
                    matcherRepository.save(match);
                }
            }
        }else {

            Matcher matcher = Matcher.builder()
                    .userId(userDto.getId())
                    .matchedUserId(matchedUserId)
                    .matchStatus(MatchStatus.PENDING)
                    .build();
            matcherRepository.save(matcher);
        }
    }
}
