package com.lmu.controller;

import com.lmu.entity.User;
import com.lmu.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @RequestMapping("login")
    @ResponseBody
    public String login(HttpServletRequest request){

        User user=  userMapper.findOne("1");

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try{
            subject.login(token);//会跳到我们自定义的realm中
            request.getSession().setAttribute("user", user);
            return "success";
        }catch(Exception e){
            e.printStackTrace();
            request.getSession().setAttribute("user", user);
            request.setAttribute("error", "用户名或密码错误！");
            return "index";
        }
    }


    /*需要登录后才能访问*/
    @RequestMapping("needLogin")
    @ResponseBody
    public String needLogin(){
        Page page=  userMapper.findAll(new PageRequest(1,2));
        return page.getContent().toString();
    }

    /*需要role【角色】才能访问*/
    @RequestMapping("needRoleVip")
    @ResponseBody
    public String needRoleVip(){
        return "角色";
    }


    /*需要Permissions【权限】才能访问*/
    @RequestMapping("needPermsVip")
    @ResponseBody
    public String needPermsVip(){
        return "权限";
    }




}
