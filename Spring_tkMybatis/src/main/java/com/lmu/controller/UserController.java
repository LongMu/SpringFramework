package com.lmu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lmu.entity.User;
import com.lmu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ProjectName: Spring_tkMybatis
 * @Package: com.lmu.controller
 * @ClassName: UserController
 * @Description:
 * @Date: 2020-12-28 9:08
 */
@RequestMapping("User")
@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("getUser")
    @ResponseBody
    public String getUser(){
       PageHelper.startPage(1,1);
       List<User> userList= userMapper.selectAll();
       PageInfo<User> userPageInfo=new PageInfo<>(userList);

       return userPageInfo.toString();
    }

}
