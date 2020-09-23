package com.km.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@TableName(value = "tb_user")
public class User {
    //plus默认主键id为long,所以声明为 @TableId(type = IdType.AUTO)
    //而且一定要写type = IdType.AUTO，这样才能添加数据的时候，为自增Id，否则就要声明为Long，因为用的是plus
    @TableId(type = IdType.AUTO)//这个一定要写啊，不然，调用deleteById要出错
    private Integer userId;

    private String userName;//boot里面的plus实体的驼峰法非常重要

    private String userPassword;

    private String userCardNo;

    private String userTel;

    private String userAddress;

    private String userPostNumber;

    private Integer userIsadmin;

    private String userQuestion;

    private String userAnswer;
    //@TableLogic//光声明没用，还要实现相应接口,分页也一样,写不写根据情况而定

}
