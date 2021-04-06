package com.rain.study.controller;


import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rain.study.pojo.AppUser;
import com.rain.study.service.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

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
     *
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
     *
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

    /**
     * 使用easyExcel从web端导出Excel
     * @param response
     * @throws IOException
     */
    @GetMapping("excel")
    public void exportExcel(HttpServletResponse response) throws IOException {
//        使用分页拿到前100000条数据
        Page<AppUser> page = new Page<>(0, 100000);
        Page<AppUser> userPage = aus.page(page);
        List<AppUser> records = userPage.getRecords();
//        设置响应头及其格式
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
//        设置文件名编码，以防中文乱码
        String fileName = URLEncoder.encode("用户表.xlsx", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''"+ fileName);
        EasyExcel.write(response.getOutputStream(), AppUser.class).sheet("表一").doWrite(records);
    }
}