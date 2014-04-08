package com.thoughtworks.hotel.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class Room {
    @NotEmpty
    @Size(min=1,max=3,message = "Invalid number")
    @Pattern(regexp = "^[0-9]+$",message = "Number must be integer")
    private String number;
    @Range(min = 1, max = 300)
    private int price;
    private Level level;

    public Room() {
    }

    public Room(String number, int price, Level level) {
        this.number = number;
        this.price = price;
        this.level = level;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}


