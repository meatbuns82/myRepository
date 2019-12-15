package com.luwenhua.springboot.service;

import com.luwenhua.springboot.enty.LoginEnty;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    LoginEnty loginQuery(LoginEnty loginEnty);
}
