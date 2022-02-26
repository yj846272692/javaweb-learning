package com.bo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: YG.
 * @Description:
 * @Date: create in 2022/2/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer id;
    private String name;
    private String cover;
    private String author;
    private String jianjie;
}
