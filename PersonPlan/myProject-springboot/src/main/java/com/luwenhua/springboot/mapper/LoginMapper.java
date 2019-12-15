package com.luwenhua.springboot.mapper;

import com.luwenhua.springboot.enty.LoginEnty;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    LoginEnty loginQuery(LoginEnty loginEnty);
}
