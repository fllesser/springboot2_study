package com.chowyijiu.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chowyijiu.boot.bean.User;
import com.chowyijiu.boot.mapper.UserMapper;
import com.chowyijiu.boot.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
