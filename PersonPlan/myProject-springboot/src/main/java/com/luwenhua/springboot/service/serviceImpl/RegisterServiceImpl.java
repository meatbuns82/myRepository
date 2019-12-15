package com.luwenhua.springboot.service.serviceImpl;

import com.luwenhua.springboot.enty.RegisterEnty;
import com.luwenhua.springboot.mapper.RegisterMapper;
import com.luwenhua.springboot.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public List<RegisterEnty> Register(RegisterEnty registerEnty) {


        return registerMapper.Register(registerEnty);
    }
}
