package com.imooc.service;

import com.imooc.dataobject.User;

/**
 * 用户端
 * Created by wwd
 */
public interface UserService {

    /**
     * 通过openid查询用户信息
     *
     * @param openid
     * @return
     */
    User findByOpenid(String openid);
}
