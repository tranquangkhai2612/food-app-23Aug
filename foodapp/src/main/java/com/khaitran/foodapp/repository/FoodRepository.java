package com.khaitran.foodapp.repository;

import com.khaitran.foodapp.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
}
