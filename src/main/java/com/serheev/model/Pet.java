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
public class Pet {
    private int id;
    private String name;
    /** Category identifier on the https://petstore.swagger.io/ */
    private int category_id;
    /** Category name on the https://petstore.swagger.io/ */
    private String category_name;
    private String status;
}
