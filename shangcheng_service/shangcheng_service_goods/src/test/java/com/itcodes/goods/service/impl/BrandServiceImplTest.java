package com.itcodes.goods.service.impl;

import com.itcodes.common.utils.Result;
import com.itcodes.common.utils.StatusCode;
import com.itcodes.goods.GoodsApplication;
import com.itcodes.goods.pojo.Brand;
import lombok.NonNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = GoodsApplication.class)
@RunWith(value = SpringRunner.class)
public class BrandServiceImplTest {

    @Test
    public void test00() {

        Brand.BrandBuilder brand = Brand.builder().id(1).name("Iphone").letter("I");
        System.out.println(brand);

        @NonNull String name = brand.build().getName();
        System.out.println(name);
        //System.out.println("xxx");
    }

    @Test
    public void test01() {
        Result<String> aaa = new Result<>(true, StatusCode.ERROR, "success");
        Brand.BrandBuilder brand = Brand.builder().id(2).name("华为").letter("H");
        Result<Brand.BrandBuilder> fail = new Result<>(false, StatusCode.OK, "fail", brand);
        System.out.println(aaa);
        System.out.println(fail);
        //Result(flag=false, code=20000, message=fail, data=Brand.BrandBuilder(id=2, name=华为, image=null, letter=H, seq=null))
    }

    @Test
    public void test02() {
        Brand brand = new Brand();
        brand.setId(2);
        brand.setName("小米");
        brand.setLetter("X");
        Result<Brand> succ = new Result<>(true, StatusCode.ACCESSERROR, "succ", brand);
        System.out.println(succ);
        //Result(flag=true, code=20003, message=succ, data=Brand(id=2, name=小米, image=null, letter=X, seq=null))

    }
}