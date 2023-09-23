package com.khaitran.foodapp.service.imp;

import com.khaitran.foodapp.dto.RestaurantDTO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RestaurantServiceImp {
    boolean insertRestaurant(MultipartFile file,
                             String title,
                             String subtitle,
                             String description,
                             boolean isFreeship,
                             String address,
                             String openDate);

    List<RestaurantDTO> getHomePageRestaurant();
}
