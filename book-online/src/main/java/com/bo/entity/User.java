package com.bo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Author: YG.
 * @Description:
 * @Date: create in 2022/2/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String account;
    private String password;
    private String nickname;
    private String avatar;
    private String address;
    private LocalDate joinDate;
}
