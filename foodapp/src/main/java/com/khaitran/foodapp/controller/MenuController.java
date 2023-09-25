package com.khaitran.foodapp.controller;

import com.khaitran.foodapp.payload.ResponseData;
import com.khaitran.foodapp.service.MenuService;
import com.khaitran.foodapp.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuServiceImp menuServiceImp;

    @PostMapping("")
    public ResponseEntity<?> createMenu(@RequestParam MultipartFile file,
                                        @RequestParam String title,
                                        @RequestParam String timeShip,
                                        @RequestParam boolean isFreeship,
                                        @RequestParam double price,
                                        @RequestParam int cateId
    ) {
        ResponseData responseData = new ResponseData();
        try {
            boolean isSuccess = menuServiceImp.createMenu(file, title, timeShip, isFreeship, price, cateId);
            responseData.setData(isSuccess);
        } catch (Exception e) {
            System.out.println("err upload fail: " + e.getMessage());
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }
}
