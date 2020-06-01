package com.itcodes.goods.pojo;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tb_brand")
@Data
@Builder    //链式设值
@AllArgsConstructor //全参构造
@NoArgsConstructor  //空参构造
@RequiredArgsConstructor    //部分非空参数构造
public class Brand implements Serializable {

    private static final long serialVersionUID = -2675170905376939920L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NonNull    //非空参数
    private Integer id;//品牌id
    @Column(name = "name")
    @NonNull    //非空参数
    private String name;//品牌名称
    @Column(name = "image")
    private String image;//品牌图片地址
    @Column(name = "letter")
    @NonNull    //非空参数
    private String letter;//品牌的首字母
    @Column(name = "seq")
    private Integer seq;//排序

}
