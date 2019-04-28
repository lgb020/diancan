package com.imooc.handler;

import com.imooc.config.ProjectUrlConfig;
import com.imooc.exception.SellerAuthorizeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wwd
 */
@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    //拦截登录异常
    //http://localhost:8080/sell/seller/category/list
    //http://localhost:8080/sell/wechat/qrAuthorize?returnUrl=http://sell.natapp4.cc/sell/seller/login
    @ExceptionHandler(value = SellerAuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        //        return new ModelAndView("redirect:"
        //                .concat(projectUrlConfig.getWechatOpenAuthorize())
        //                .concat("/sell/wechat/qrAuthorize")
        //                .concat("?returnUrl=")
        //                .concat(projectUrlConfig.getSell())
        //                .concat("/sell/seller/login"));
        return new ModelAndView("common/loginView");
        //        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");
    }
}
