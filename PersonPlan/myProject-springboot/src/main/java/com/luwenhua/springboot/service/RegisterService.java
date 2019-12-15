package com.luwenhua.springboot.service;

import com.luwenhua.springboot.enty.RegisterEnty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RegisterService {

    List<RegisterEnty> Register(RegisterEnty registerEnty);
}
