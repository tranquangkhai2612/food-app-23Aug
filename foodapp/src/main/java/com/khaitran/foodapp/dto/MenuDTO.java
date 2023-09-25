package com.khaitran.foodapp.dto;

public class MenuDTO {
    private String title;
    private String image;
    private String timeShip;
    private boolean isFreeship;
    private String price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTimeShip() {
        return timeShip;
    }

    public void setTimeShip(String timeShip) {
        this.timeShip = timeShip;
    }

    public boolean isFreeship() {
        return isFreeship;
    }

    public void setFreeship(boolean freeship) {
        isFreeship = freeship;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
