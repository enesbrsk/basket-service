package com.service.englishdise.model;

import com.service.englishdise.enums.MatchStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "matchers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Matcher extends BaseEntity{

    private Long userId;
    private Long matchedUserId;
    @Enumerated(EnumType.STRING)
    private MatchStatus matchStatus;
}
