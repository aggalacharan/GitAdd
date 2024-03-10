package com.dxccode.orderservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;



@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity(name = "foodItem")
public class FoodItemInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodId;
    private String foodName;
    private String description;
    private String restaurantName;
    private double price;
    //private double tax;
    private int quantity;
    private String restaurantId;

    @ManyToOne
    private OrderInfo orderInfo;


    public FoodItemInfo(String foodId, String foodName, double price, String description, int quantity, String res_id, OrderInfo orderInfo) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.restaurantId = res_id;
        this.orderInfo = orderInfo;
    }
}
