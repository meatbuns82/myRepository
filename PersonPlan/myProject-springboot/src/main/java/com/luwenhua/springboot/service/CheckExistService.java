package com.luwenhua.springboot.service;

import com.luwenhua.springboot.enty.LoginEnty;
import com.luwenhua.springboot.enty.RegisterEnty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CheckExistService {

    Boolean queryExist(RegisterEnty registerEnty);

    List checkUserIsEffective(LoginEnty loginEnty);

}
