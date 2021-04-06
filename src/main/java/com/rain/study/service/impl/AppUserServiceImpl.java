package com.rain.study.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rain.study.mapper.AppUserMapper;
import com.rain.study.pojo.AppUser;
import com.rain.study.service.AppUserService;
import org.springframework.stereotype.Service;


/**
 * app用户表(AppUser)表服务实现类
 *
 * @author makejava
 * @since 2021-04-06 14:12:52
 */
@Service("appUserService")
public class AppUserServiceImpl extends ServiceImpl<AppUserMapper, AppUser> implements AppUserService {


}