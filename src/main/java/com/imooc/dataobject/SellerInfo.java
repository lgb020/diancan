package com.imooc.dataobject;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * Created by wwd
 */
@Data
@Entity
@DynamicUpdate
@DynamicInsert
public class SellerInfo {

    @Id
    @GeneratedValue
    private Integer sellerId;

    private String username;

    private String password;

    private String phone;

    private Date createTime;

    private Date updateTime;
}
