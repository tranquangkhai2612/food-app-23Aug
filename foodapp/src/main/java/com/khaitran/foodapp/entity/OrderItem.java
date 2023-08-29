package com.khaitran.foodapp.entity;

import com.khaitran.foodapp.entity.keys.KeyOrderItem;
import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "OrderItem")
public class OrderItem {
    @EmbeddedId
    KeyOrderItem keyOrderItem;

    @ManyToOne
    @JoinColumn(name = "order_id",insertable = false,updatable = false)
    private Orders order;
    @ManyToOne
    @JoinColumn(name = "food_id",insertable = false,updatable = false)
    private Food food;
    @Column(name = "create_date")
    private Date createdDate;

    public KeyOrderItem getKeys() {
        return keyOrderItem;
    }

    public void setKeys(KeyOrderItem keyOrderItem) {
        this.keyOrderItem = keyOrderItem;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
