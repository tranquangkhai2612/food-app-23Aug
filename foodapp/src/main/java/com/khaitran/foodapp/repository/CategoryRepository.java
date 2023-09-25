package com.khaitran.foodapp.repository;

import com.khaitran.foodapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
