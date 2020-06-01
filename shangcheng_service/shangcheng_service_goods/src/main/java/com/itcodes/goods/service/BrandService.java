package com.itcodes.goods.service;

import com.github.pagehelper.PageInfo;
import com.itcodes.goods.pojo.Brand;

import java.util.List;

/**
 * @ClassName BrandService
 * @Author sussen
 * @Version 1.0.0
 * @Date 2020/5/31
 */
public interface BrandService {

    List<Brand> findAll();

    Brand findById(Integer id);

    void add(Brand brand);

    void delete(Integer id);

    void update(Brand brand);

    List<Brand> findList(Brand brand);

    PageInfo<Brand> findPage(Integer page, Integer size);

    PageInfo<Brand> findPage(Brand brand, Integer page, Integer size);
}
