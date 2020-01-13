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
    private int category_id;
    private String category_name;
    private String status;
}
