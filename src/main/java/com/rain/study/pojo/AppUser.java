package com.rain.study.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * app用户表(AppUser)实体类
 *
 * @author makejava
 * @since 2021-04-06 14:12:52
 */
@Data
public class AppUser implements Serializable {
    private static final long serialVersionUID = -62031929121266132L;

    private Integer id;
    /**
     * 用户昵称
     */
    private String name;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 性别（0:男；1：女）
     */
    private Integer gender;
    /**
     * 密码
     */
    private String password;
    /**
     * 年龄
     */
    private Integer age;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @TableLogic
    private Integer deleteFlag;
}