package com.imooc.repository;

import com.imooc.dataobject.SellerInfo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wwd
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, Integer> {
    SellerInfo findByPhone(String phone);

    SellerInfo findBySellerId(Integer sellerId);
}
