package com.imooc.service.impl;

import com.imooc.dataobject.User;
import com.imooc.repository.UserRepository;
import com.imooc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wwd
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User findByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
