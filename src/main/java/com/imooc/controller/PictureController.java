package com.imooc.controller;

import com.imooc.VO.ResultVO;
import com.imooc.dataobject.Picture;
import com.imooc.repository.PictureRepository;
import com.imooc.utils.ResultVOUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
