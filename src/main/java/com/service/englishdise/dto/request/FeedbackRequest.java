package com.service.englishdise.dto.request;

import com.service.englishdise.enums.StarRating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FeedbackRequest {

    private Long profileId;
    private Long feedbackProfileId;
    private String comment;
    private StarRating stars;

}
