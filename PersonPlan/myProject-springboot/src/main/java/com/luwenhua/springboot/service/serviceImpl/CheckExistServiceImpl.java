package com.luwenhua.springboot.service.serviceImpl;

import com.luwenhua.springboot.enty.LoginEnty;
import com.luwenhua.springboot.enty.RegisterEnty;
import com.luwenhua.springboot.mapper.CheckExistMapper;
import com.luwenhua.springboot.service.CheckExistService;
import com.luwenhua.springboot.setup.PasswordUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CheckExistServiceImpl implements CheckExistService{

    @Autowired
    private CheckExistMapper checkExistMapper;


    @Override
    public Boolean queryExist(RegisterEnty registerEnty) {
        if(checkExistMapper.queryExist(registerEnty).get(0).getUsercount() == null){
            return false;   //如果为空返回 false 没有此账户，可以注册
        }else {
            return true;
        }
    }

    @Override
    public List checkUserIsEffective(LoginEnty loginEnty) {
         List list = new ArrayList();  //list存储返回的信息 0 代表登陆失败--统一提示为用户名或密码错误，1代表登陆成功 -1代表用户不存在 2代表冻结

        if(loginEnty == null){  // 判断查询结果
            log.info("用户不存在未注册账户");
            list.add(0,"-1");
        }
        if("0".equals(loginEnty.getStatus())){
            log.info("用户已经注销"+loginEnty.getUsercount());
            list.add(0,"-1");
        }
        if("2".equals(loginEnty.getStatus())){
            log.info("用户已经冻结"+loginEnty.getUsercount());
            list.add(0,"2");
        }

        return list;
    }


}
