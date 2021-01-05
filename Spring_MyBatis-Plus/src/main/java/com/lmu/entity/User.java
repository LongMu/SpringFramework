package com.lmu.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ProjectName: spring-demo
 * @Package: com.lmu.entity
 * @ClassName: User
 * @Description: userEntity
 * @Date: 2020-12-5 14:45
 */
@TableName("user")
public class User {
    @TableId(value = "ID")
    private String id;

    @TableField(value = "USERNAME")
    private String userName;

    @TableField(value = "SEX")
    private String sex;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
