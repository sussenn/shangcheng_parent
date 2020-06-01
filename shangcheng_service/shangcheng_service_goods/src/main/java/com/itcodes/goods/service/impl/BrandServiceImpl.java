package com.itcodes.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itcodes.goods.dao.BrandMapper;
import com.itcodes.goods.pojo.Brand;
import com.itcodes.goods.service.BrandService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @ClassName BrandServiceImpl
 * @Author sussen
 * @Version 1.0
 * @Date 2020/5/31
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;


    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        /*
         * insertSelective: 拼接SQL语句的时候,会忽略对象的空值属性
         * insert:  不会忽略空值属性
         */
        brandMapper.insertSelective(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public List<Brand> findList(Brand brand) {
        Example example = getExample(brand);
        return brandMapper.selectByExample(example);
    }

    //方法重载. (方法名相同,参数不同)
    @Override
    public PageInfo<Brand> findPage(Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        //查询
        List<Brand> brands = brandMapper.selectAll();
        //返回pageInfo
        return new PageInfo<>(brands);
    }

    @Override
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {
        //分页
        PageHelper.startPage(page,size);
        //构建条件查询
        Example example = getExample(brand);
        List<Brand> brands = brandMapper.selectByExample(example);
        //封装pageInfo
        return new PageInfo<>(brands);
    }


    //查询条件构造
    private Example getExample(Brand brand) {
        //自定义条件查询
        Example example = new Example(Brand.class);
        //条件构造器
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(brand.getName())) {
            //根据 name 模糊查询
            criteria.andLike("name", "%" + brand.getName() + "%");
        }
        if (!StringUtils.isEmpty(brand.getLetter())) {
            //根据 letter 查询
            criteria.andEqualTo("letter", brand.getLetter());
        }
        return example;
    }

}
