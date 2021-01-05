package com.lmu.config;

import cn.hutool.crypto.SecureUtil;
import com.lmu.entity.User;
import com.lmu.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: Spring_Apacheshiro
 * @Package: com.lmu.config
 * @ClassName: SaasRealm
 * @Description:
 * @Date: 2020-12-28 16:32
 */
public class SaasRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    // 为当前登陆成功的用户授予权限和角色，已经登陆成功了
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String username = (String) principals.getPrimaryPrincipal(); //获取用户名
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> rolesSet=new HashSet<>();
        /*模拟查找角色*/
        rolesSet.add("vip");
        authorizationInfo.setRoles(rolesSet);
        Set<String> permissionsSet=new HashSet<>();
        /*模拟查找权限*/
        permissionsSet.add("vip");
        authorizationInfo.setStringPermissions(permissionsSet);
        return authorizationInfo;
    }


    // 验证当前登录的用户，获取认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
            String username = (String) token.getPrincipal(); // 获取用户名
            /*数据库查询账户密码验证登录*/
            User user = userMapper.findOne("1");
            if(user != null) {
                /*这里传入用户名密码 和 UsernamePasswordToken里面的验证*/
                AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUsername(),
                        user.getPassword(),
                        "myRealm");
                return authcInfo;
            } else {
                return null;
            }
    }
}
