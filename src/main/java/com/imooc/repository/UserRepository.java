package com.imooc.repository;

import com.imooc.dataobject.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wwd
 */
public interface UserRepository extends JpaRepository<User, String> {
    User findByOpenid(String openid);
}
