package com.imooc.form;

import java.util.Date;

import lombok.Data;

/**
 * Created by wwd
 */
@Data
public class PictureForm {

    private Integer picId;
    private String picUrl;
    private String picMessage;
    private Date picCreate;
}
