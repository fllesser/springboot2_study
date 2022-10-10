package com.chowyijiu.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chowyijiu.boot.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
