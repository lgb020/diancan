package com.imooc.dataobject;

import org.hibernate.annotations.DynamicInsert;

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
@DynamicInsert
public class Picture {

    @Id
    @GeneratedValue
    private int picId;
    private String picUrl;
    private String picMessage;
    private Date picCreate;
}
