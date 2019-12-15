package com.luwenhua.springboot.service.serviceImpl;

import com.luwenhua.springboot.enty.LoginEnty;
import com.luwenhua.springboot.mapper.LoginMapper;
import com.luwenhua.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public LoginEnty loginQuery(LoginEnty loginEnty) {

        return loginMapper.loginQuery(loginEnty);
    }
}
