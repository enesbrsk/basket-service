package com.service.englishdise.service;

import com.service.englishdise.dto.request.FeedbackRequest;
import com.service.englishdise.model.Feedback;
import com.service.englishdise.model.Profile;
import com.service.englishdise.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback createFeedback(FeedbackRequest feedbackRequest){

        Profile profile = Profile.builder()
                .userId(feedbackRequest.getProfileId())
                .build();

        Feedback feedback = Feedback.builder()
                .profile(profile)
                .feedbackUserId(feedbackRequest.getFeedbackProfileId())
                .comment(feedbackRequest.getComment())
                .stars(feedbackRequest.getStars())
                .build();

        return feedbackRepository.save(feedback);

    }

}
