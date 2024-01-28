package com.service.basket.service;

import com.service.basket.dto.UserDto;
import com.service.basket.model.Basket;
import com.service.basket.model.ProfileInformation;
import com.service.basket.repository.ProfileInformationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileInformationService {

    private final ProfileInformationRepository profileInformationRepository;
    private final UserService userService;
    private final BasketService basketService;

    public ProfileInformationService(ProfileInformationRepository profileInformationRepository, UserService userService, BasketService basketService) {
        this.profileInformationRepository = profileInformationRepository;
        this.userService = userService;
        this.basketService = basketService;
    }

    public ProfileInformation getAllProfileInformation() {

        UserDto userDto = userService.findUserInContext();
        List<Basket> basketList = basketService.getBasketByUserId();
        ProfileInformation profileInformation = ProfileInformation.builder()
                .userId(userDto.getId())
                .lastOperationDate(basketList.get(0).getCreateDate())
                .lastOperationLocation("Migros")
                .build();


        return profileInformation;

    }



}
