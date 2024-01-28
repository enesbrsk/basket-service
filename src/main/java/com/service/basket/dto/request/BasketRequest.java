package com.service.basket.dto.request;

import lombok.*;
import org.springframework.stereotype.Service;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasketRequest {

    private String barcodeId;

}
