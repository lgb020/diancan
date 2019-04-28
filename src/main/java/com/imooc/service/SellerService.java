package com.imooc.service;

import com.imooc.dataobject.SellerInfo;

/**
 * 卖家端
 * Created by wwd
 */
public interface SellerService {

    /**
     * 通过openid查询卖家端信息
     * @return
     */
    SellerInfo findSellerInfoByPhone(String phone);
}
