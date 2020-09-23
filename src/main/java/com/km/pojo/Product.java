package com.km.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName(value = "tb_product")//可以改成对应数据库的表名，靠他
public class Product {
    //而且一定要写type = IdType.AUTO，这样才能添加数据的时候，为自增Id，否则就要声明为Long，因为用的是plus
    @TableId(type = IdType.AUTO)//这个一定要写啊，不然，调用deleteById要出错,
    private Integer pId;
    private String pName;
    private Double pPrice;
    private String pDes;
    private Double pDiscountPrice;
    private String pImage;

    @TableLogic//光声明没用，还要实现相应接口,分页也一样,逻辑删除的注解
    private Integer pDeleted;

}
