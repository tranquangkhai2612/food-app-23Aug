package com.khaitran.foodapp.dto;

import java.util.List;

public class CategoryDTO {
    private List<MenuDTO> menuDTOS;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuDTO> getMenuDTOS() {
        return menuDTOS;
    }

    public void setMenuDTOS(List<MenuDTO> menuDTOS) {
        this.menuDTOS = menuDTOS;
    }
}
