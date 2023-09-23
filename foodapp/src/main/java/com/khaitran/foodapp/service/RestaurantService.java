package com.khaitran.foodapp.service;

import com.khaitran.foodapp.dto.RestaurantDTO;
import com.khaitran.foodapp.entity.RatingRestaurant;
import com.khaitran.foodapp.entity.Restaurant;
import com.khaitran.foodapp.repository.RestaurantRepository;
import com.khaitran.foodapp.service.imp.FileServiceImp;
import com.khaitran.foodapp.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class RestaurantService implements RestaurantServiceImp {
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    FileServiceImp fileServiceImp;

    @Override
    public boolean insertRestaurant(MultipartFile file, String title, String subtitle, String description, boolean isFreeship, String address, String openDate) {
        boolean isInsertSuccess = false;
        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess) {
                Restaurant restaurant = new Restaurant();
                restaurant.setTitle(title);
                restaurant.setSubtitle(subtitle);
                restaurant.setDescription(description);
                restaurant.setImage(file.getOriginalFilename()); //set filename, not file directory avoid crash server
                restaurant.setFreeship(isFreeship);
                restaurant.setAddress(address);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
                Date openDateParsed = simpleDateFormat.parse(openDate);
                restaurant.setOpenDate(openDateParsed);

                restaurantRepository.save(restaurant);
                isInsertSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("Err insert restaurant: " + e.getMessage());
        }

        return isInsertSuccess;
    }

    @Override
    public List<RestaurantDTO> getHomePageRestaurant() {
        //paging: set number of obj send to UI -> 6 res only
        PageRequest pageRequest = PageRequest.of(0, 6);
        Page<Restaurant> listData = restaurantRepository.findAll(pageRequest);
        List<RestaurantDTO> restaurantDTOS = new ArrayList<>();
        for (Restaurant data : listData) {
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.setImage(data.getImage());
            restaurantDTO.setTitle(data.getTitle());
            restaurantDTO.setSubtitle(data.getSubtitle());
            restaurantDTO.setFreeship(data.isFreeship());
            restaurantDTO.setRating(calculateRating(data.getListRatingRestaurant()));

            restaurantDTOS.add(restaurantDTO);
        }
        return restaurantDTOS;
    }

    private double calculateRating(Set<RatingRestaurant> ratingRestaurants) {
        double totalPoint = 0;
        for (RatingRestaurant data : ratingRestaurants) {
            totalPoint += data.getRatePoint();
        }

        return totalPoint / ratingRestaurants.size();
    }
}
