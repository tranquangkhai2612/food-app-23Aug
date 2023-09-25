package com.khaitran.foodapp.service;

import com.khaitran.foodapp.entity.Category;
import com.khaitran.foodapp.entity.Food;
import com.khaitran.foodapp.entity.Restaurant;
import com.khaitran.foodapp.repository.FoodRepository;
import com.khaitran.foodapp.service.imp.FileServiceImp;
import com.khaitran.foodapp.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class MenuService implements MenuServiceImp {
    @Autowired
    FileServiceImp fileServiceImp;
    @Autowired
    FoodRepository foodRepository;


    @Override
    public boolean createMenu(MultipartFile file, String title, String timeShip, boolean isFreeship, double price, int cateId) {
        boolean isInsertSuccess = false;
        try {
            boolean isSaveFileSuccess = fileServiceImp.saveFile(file);
            if (isSaveFileSuccess) {
                Food food = new Food();
                food.setTitle(title);
                food.setImage(file.getOriginalFilename());
                food.setTimeShip(timeShip);
                food.setPrice(price);
                food.setFreeship(isFreeship);
                Category category = new Category();
                category.setId(cateId);
                food.setCategory(category);

                foodRepository.save(food);

                isInsertSuccess = true;
            }
        } catch (Exception e) {
            System.out.println("Err insert menu: " + e.getMessage());
        }

        return isInsertSuccess;
    }
}
