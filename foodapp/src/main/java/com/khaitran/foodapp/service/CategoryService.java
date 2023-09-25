package com.khaitran.foodapp.service;

import com.khaitran.foodapp.dto.CategoryDTO;
import com.khaitran.foodapp.service.imp.CategoryServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryServiceImp {
    @Autowired
    CategoryServiceImp categoryServiceImp;

    @Override
    public List<CategoryDTO> getCategory() {
        return null;
    }
}
