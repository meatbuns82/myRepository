package com.luwenhua.springboot.enty;

import lombok.Data;

@Data
public class RegisterEnty {


    private String username;

    private String password;

    private String usercount;

    private String salt; //密码盐

    private String avatar; //用户头像地址

    private String sex;

    private String status;

    private String tel;

    private String identify;

    private String city;
}
