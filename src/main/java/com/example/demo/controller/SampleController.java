package com.example.demo.controller;

import com.example.demo.domain.LinkConfig;
import com.example.demo.domain.Result;
import com.example.demo.domain.User;
import com.example.demo.domain.UserInfo;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.GlobalException;
import com.example.demo.redis.RedisService;
import com.example.demo.redis.UserKey;
import com.example.demo.service.WapHallService;
import com.example.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @Autowired
    RedisService redisService;


    @Autowired
    WapHallService wapHallService;


    @RequestMapping("/test1")
    @ResponseBody
    public Result<Boolean> dbGet() {
        return ResultUtil.success(true);
    }

    @RequestMapping("/fail")
    @ResponseBody
    public Result<ResultEnum> dbSet() {
        return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
    }

    @RequestMapping("/exc")
    @ResponseBody
    public Result<ResultEnum> dbexc() throws Exception {
        throw new GlobalException(ResultEnum.EXCP);
    }

    @RequestMapping("/redis/setredis")
    @ResponseBody
    public Result<Boolean> redisSet() {
        User user = new User();
        user.setId(1);
        user.setName("111111");
        boolean v1 = redisService.set(UserKey.getById,""+1,user);
        return ResultUtil.success(true);
    }

    @RequestMapping("/redis/getredis")
    @ResponseBody
    public Result<Boolean> redisGet() {
        User user = redisService.get(UserKey.getById,""+1,User.class);
        //redis的key是什么  UserKey:id1
        return ResultUtil.success(user);
    }

//    @RequestMapping("/mybatis/test")
//    @ResponseBody
//    public Result<Boolean> mybatisGet() {
//        UserInfo user = userService.getUserById(83L);
//        //redis的key是什么  UserKey:id1
//        return ResultUtil.success(user);
//    }

    @RequestMapping("/mybatis/study")
    @ResponseBody
    public Result<LinkConfig> mybatisStudy() {
        LinkConfig linkconfig = wapHallService.getLinkConfigByType(77);
        //redis的key是什么  UserKey:id1
        System.out.println(linkconfig.getImageName());
        return ResultUtil.success(linkconfig);
    }








}
