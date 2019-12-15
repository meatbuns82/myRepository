package com.luwenhua.springboot.controller;


import com.luwenhua.springboot.enty.LoginEnty;
import com.luwenhua.springboot.mapper.RegisterMapper;
import com.luwenhua.springboot.mapper.LoginMapper;
import com.luwenhua.springboot.setup.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class queryController {

    @Autowired
    private RegisterMapper queryMapper;

    @Autowired
    private LoginMapper loginMapper;

//    @RequestMapping(value = "/query")
//    public List<LoginEnty> query(){
//
//       //List<LoginEnty> list =  queryMapper.queryAll();
//
//       return list;
//    }

//    @RequestMapping(value = "/qone")
//    public LoginEnty queryOne(){
//
//        LoginEnty loginModel = loginMapper.loginQuery()
//
//        return loginModel;
//    }

    @RequestMapping(value = "/secret")
    public void secret(){
     String str = "lwh136..";
     String password = "lwh@qq.com";
        System.out.println("明文"+str);
        System.out.println("密码"+password);

//
//        try {
//            byte[] salt = PasswordUtil.getStaticSalt();
//            String ciphertext = PasswordUtil.entrcy(str,password,salt);
//            System.out.println("-----密文----"+ciphertext);
//            String plaintext = PasswordUtil.decrypt(ciphertext,password,salt);
//            System.out.println("明文"+plaintext);
//            String result = PasswordUtil.decrypt("3af1847015d62670ff1b2c3f67bda10e","zffdsf",salt);
//            System.out.println("明文"+result);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}
