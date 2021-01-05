package com.lmu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lmu.entity.User;

import java.util.List;

/**
 * @ProjectName: Spring_MVC
 * @Package: com.lmu.service
 * @ClassName: userService
 * @Description:
 * @Date: 2020-12-24 14:39
 */
public interface UserService extends IService<User> {
   List<User> selectAll();

}
