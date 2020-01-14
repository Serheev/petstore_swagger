package com.serheev.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private int id;
    /** Pet identifier on the https://petstore.swagger.io/ */
    private int petId;
    private int quantity;
    private String status;
    private boolean complete;
}

