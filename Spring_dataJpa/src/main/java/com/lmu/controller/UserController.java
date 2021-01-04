package com.lmu.controller;

import com.lmu.entity.User;
import com.lmu.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
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
        Page page=  userMapper.findAll(new PageRequest(1,2));
        return page.getContent().toString();
    }

}
