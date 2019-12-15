package com.luwenhua.springboot.mapper;

import com.luwenhua.springboot.enty.RegisterEnty;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CheckExistMapper {
    List<RegisterEnty> queryExist(RegisterEnty registerEnty);
}
