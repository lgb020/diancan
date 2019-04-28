package com.imooc.repository;

import com.imooc.dataobject.Picture;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wwd
 */
public interface PictureRepository extends JpaRepository<Picture, Integer> {
}
