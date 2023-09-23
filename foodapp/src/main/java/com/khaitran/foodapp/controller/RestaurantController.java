package com.khaitran.foodapp.controller;

import com.khaitran.foodapp.payload.ResponseData;
import com.khaitran.foodapp.service.RestaurantService;
import com.khaitran.foodapp.service.imp.FileServiceImp;
import com.khaitran.foodapp.service.imp.RestaurantServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    FileServiceImp fileServiceImp;
    @Autowired
    RestaurantServiceImp restaurantServiceImp;

    @PostMapping("")
    public ResponseEntity<?> createRestaurant(@RequestParam MultipartFile file,
                                              @RequestParam String title,
                                              @RequestParam String subtitle,
                                              @RequestParam String description,
                                              @RequestParam boolean isFreeship,
                                              @RequestParam String address,
                                              @RequestParam String openDate
    ) {
        ResponseData responseData = new ResponseData();
        try {
            boolean isSuccess = restaurantServiceImp.insertRestaurant(file, title, subtitle, description, isFreeship, address, openDate);
            responseData.setData(isSuccess);
        } catch (Exception e) {
            System.out.println("err upload fail: " + e.getMessage());
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<?> getFileRestaurant(@PathVariable String fileName) {
        Resource resource = fileServiceImp.loadFile(fileName);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"").body(resource);
    }

    @GetMapping("")
    public ResponseEntity<?> getHomeRestaurants() {
        ResponseData responseData = new ResponseData();
        responseData.setData(restaurantServiceImp.getHomePageRestaurant());

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
