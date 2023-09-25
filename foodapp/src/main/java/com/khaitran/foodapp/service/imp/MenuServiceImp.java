package com.khaitran.foodapp.service.imp;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface MenuServiceImp {
    boolean createMenu(MultipartFile file,
                       String title,
                       String timeShip,
                       boolean isFreeship,
                       double price,
                       int cateId);
}
