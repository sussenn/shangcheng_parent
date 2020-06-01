package com.itcodes.goods.controller;

import com.github.pagehelper.PageInfo;
import com.itcodes.common.utils.Result;
import com.itcodes.common.utils.StatusCode;
import com.itcodes.goods.pojo.Brand;
import com.itcodes.goods.service.BrandService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName BrandController   商品品牌操作控制层
 * @Author sussen
 * @Version 1.0
 * @Date 2020/5/31
 */
@RestController
@RequestMapping(value = "/brand")
@CrossOrigin    //允许跨域伪造请求
public class BrandController {

    @Autowired
    private BrandService brandService;

    //查询所有品牌
    @GetMapping
    public Result<List<Brand>> findAll(){
        //int q=10/0;
        List<Brand> brands = brandService.findAll();
        return new Result<>(true, StatusCode.OK, "查询所有品牌成功!", brands);
    }

    //根据Id查询品牌信息
    @GetMapping(value = "/{id}")
    public Result<Brand> findById(@PathVariable(value = "id")Integer id){
        //调用Service查询
        Brand brand = brandService.findById(id);
        return new Result<>(true, StatusCode.OK, "根据ID查询成功!", brand);
    }

    //新增品牌
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result<Brand>(true, StatusCode.OK, "增加品牌成功!");
    }

    //修改品牌
    @PutMapping
    public Result update(@RequestBody Brand brand){
        brandService.update(brand);
        return new Result<Brand>(true, StatusCode.OK, "修改品牌成功!");
    }

    //删除品牌
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id")Integer id){
        brandService.delete(id);
        return new Result<Brand>(true, StatusCode.OK, "删除品牌成功!");
    }

    //条件查询
    @PostMapping(value = "/search")
    public Result<List<Brand>> findList(@NonNull @RequestBody Brand brand){
        //调用Service查询即可
        List<Brand> brands = brandService.findList(brand);
        return new Result<>(true, StatusCode.OK, "条件查询品牌成功!",brands);
    }

    //分页查询
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value = "page")Integer page,@PathVariable(value = "size")Integer size){
        //调用分页查询
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<>(true, StatusCode.OK, "分页查询品牌!",pageInfo);
    }

    //分页条件查询+分页
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand,@PathVariable(value = "page")Integer page,@PathVariable(value = "size")Integer size){
        //调用Service查询
        PageInfo<Brand> pageInfo = brandService.findPage(brand, page, size);
        return new Result<>(true, StatusCode.OK, "分页条件查询品牌!", pageInfo);
    }
}
