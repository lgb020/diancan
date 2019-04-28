package com.imooc.aspect;

import com.imooc.constant.CookieConstant;
import com.imooc.exception.SellerAuthorizeException;
import com.imooc.utils.CookieUtil;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by wwd
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {


    //    @Pointcut("execution(public * com.imooc.controller.Seller*.*(..))" +
    //    "&& !execution(public * com.imooc.controller.SellerUserController.*(..))")
    @Pointcut("execution(public * com.imooc.controller.Seller*.*(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】Cookie中查不到token");
            throw new SellerAuthorizeException();
        }
    }
}
