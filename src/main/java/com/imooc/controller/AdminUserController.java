package com.imooc.controller;

import com.imooc.constant.CookieConstant;
import com.imooc.constant.RedisConstant;
import com.imooc.dataobject.SellerInfo;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.SellException;
import com.imooc.form.SellerForm;
import com.imooc.repository.SellerInfoRepository;
import com.imooc.utils.CookieUtil;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminUserController {

    @Autowired
    SellerInfoRepository repository;

    @GetMapping("/loginAdmin")
    public String loginAdmin(@RequestParam("phone") String phone,
                             @RequestParam("password") String password,
                             HttpServletResponse response) {
        SellerInfo sellerInfo = repository.findByPhone(phone);
        log.info("商家信息={}", sellerInfo);
        if (sellerInfo != null && sellerInfo.getPassword().equals(password)) {
            String token = UUID.randomUUID().toString();
            log.info("登录成功的token={}", token);
            Integer expire = RedisConstant.EXPIRE;
            //3. 设置token至cookie
            CookieUtil.set(response, CookieConstant.TOKEN, token, expire);
            return "登录成功";
        } else {
            throw new SellException(ResultEnum.LOGIN_FAIL);
        }
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        //1. 从cookie里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //2. 清除cookie
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success", map);
    }

    /*
     * 页面相关
     * */

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<SellerInfo> categoryList = repository.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("admin/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "sellerId", required = false) Integer sellerId,
                              Map<String, Object> map) {
        SellerInfo sellerInfo = repository.findBySellerId(sellerId);
        map.put("category", sellerInfo);

        return new ModelAndView("admin/index", map);
    }

    /**
     * 保存/更新
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid SellerForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        log.info("SellerForm={}", form);
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/admin/index");
            return new ModelAndView("common/error", map);
        }
        SellerInfo sellerInfo = new SellerInfo();
        try {
            if (form.getSellerId() != null) {
                sellerInfo = repository.findBySellerId(form.getSellerId());
            }
            BeanUtils.copyProperties(form, sellerInfo);
            repository.save(sellerInfo);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/admin/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/admin/list");
        return new ModelAndView("common/success", map);
    }
}