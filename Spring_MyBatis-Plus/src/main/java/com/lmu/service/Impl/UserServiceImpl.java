package com.lmu.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lmu.mapper.UserMapper;
import com.lmu.entity.User;
import com.lmu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: Spring_MVC
 * @Package: com.lmu.service.Impl
 * @ClassName: UserServiceImpl
 * @Description:
 * @Date: 2020-12-24 14:41
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll(new Page<User>(1,5)).getRecords();
    }
}
