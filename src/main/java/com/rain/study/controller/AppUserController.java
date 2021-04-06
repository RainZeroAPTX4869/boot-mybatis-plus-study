package com.rain.study.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rain.study.pojo.AppUser;
import com.rain.study.service.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * app用户表(AppUser)表控制层
 *
 * @author makejava
 * @since 2021-04-06 14:12:52
 */
@Controller
@RequestMapping("appUser")
public class AppUserController {

    @Resource
    private AppUserService aus;
    @Resource
    private ObjectMapper objectMapper;

    /**
     * 逻辑删除某条记录
     * @param id
     * @return 调用分页查询方法queryPage的结果
     * @throws JsonProcessingException
     */
    @ResponseBody
    @PostMapping("delete")
    public String editInfoDelete(@RequestParam("id") int id) throws JsonProcessingException {
        aus.removeById(id);
        return this.queryPage(1);
    }

    /**
     * 分页查询所有内容
     * @param pn
     * @return json字符串
     * @throws JsonProcessingException
     */
    @ResponseBody
    @PostMapping("queryPage")
    public String queryPage(@RequestParam(name = "pn", defaultValue = "1") int pn) throws JsonProcessingException {
        Page<AppUser> page = new Page<>(pn, 10);
        return objectMapper.writeValueAsString(aus.page(page));
    }
}