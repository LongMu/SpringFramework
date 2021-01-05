package com.lmu.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmu.mapper.UserMapper;
import com.lmu.entity.User;
import com.lmu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("show")
    public void show(){
        Page<User> page = new Page<>(1, 1);
        IPage<User> userIPage=userMapper.selectAll(page);
        System.out.println(userIPage.getRecords().size());
    }


    @RequestMapping("pageUser")
    public void pageUser(){
        QueryWrapper<User> query = Wrappers.query();
        Page<User> page = new Page<>(1, 5);
        IPage<User> userIPage = userMapper.selectPage(page, query);
        System.out.println(userIPage.getRecords().size());
    }
}
