package com.service.englishdise.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.service.englishdise.enums.StarRating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "feedbacks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Feedback extends BaseEntity {


    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;
    private Long feedbackUserId;
    private String comment;
    @Enumerated(EnumType.STRING)
    private StarRating stars;
}
