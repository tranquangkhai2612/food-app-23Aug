package com.khaitran.foodapp.entity;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;

import java.util.Date;
import java.util.Set;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "create_date")
    private Date createdDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "res_id")
    private Restaurant restaurant;
    @OneToMany(mappedBy = "order")
    private Set<OrderItem> listOrderItem;

    public Set<OrderItem> getListOrderItem() {
        return listOrderItem;
    }

    public void setListOrderItem(Set<OrderItem> listOrderItem) {
        this.listOrderItem = listOrderItem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
