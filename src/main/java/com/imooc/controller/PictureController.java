package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.dataobject.Picture;
import com.imooc.exception.SellException;
import com.imooc.form.PictureForm;
import com.imooc.repository.PictureRepository;
import com.imooc.utils.ResultVOUtil;

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

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户相关
 */
@RestController
@RequestMapping("/picture")
@Slf4j
public class PictureController {

    @Autowired
    PictureRepository repository;


    @GetMapping("/getAll")
    public ResultVO getUserInfo() {
        List<Picture> pictures = repository.findAll();
        return ResultVOUtil.success(pictures);
    }
    /*
     * 页面相关
     * */

    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<Picture> pictures = repository.findAll();
        map.put("categoryList", pictures);
        return new ModelAndView("picture/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "picId", required = false) Integer picId,
                              Map<String, Object> map) {
        Picture picture = repository.findByPicId(picId);
        map.put("category", picture);

        return new ModelAndView("picture/index", map);
    }

    /**
     * 保存/更新
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid PictureForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        log.info("SellerForm={}", form);
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/picture/index");
            return new ModelAndView("common/error", map);
        }
        Picture picture = new Picture();
        try {
            if (form.getPicId() != null) {
                picture = repository.findByPicId(form.getPicId());
            }
            BeanUtils.copyProperties(form, picture);
            repository.save(picture);
        } catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/picture/index");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/sell/picture/list");
        return new ModelAndView("common/success", map);
    }

}
