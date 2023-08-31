package com.service.englishdise.controller;

import com.service.englishdise.dto.request.FeedbackRequest;
import com.service.englishdise.model.Feedback;
import com.service.englishdise.service.FeedbackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/feedback")
    public ResponseEntity<Feedback> createFeedback(@RequestBody FeedbackRequest feedbackRequest){
        return ResponseEntity.ok(feedbackService.createFeedback(feedbackRequest));
    }

}
