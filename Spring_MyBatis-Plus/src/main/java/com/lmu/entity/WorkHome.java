package com.lmu.entity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ProjectName: spring-demo
 * @Package: com.lmu.entity
 * @ClassName: WorkHome
 * @Description: WorkHome
 * @Date: 2020-12-7 9:40
 */
public class WorkHome {
    private User user;

    private List<User> users;
    private String[] strings;

    private String homeName;

    private Map<String,String> map;
    private Set<String> set;

    @Override
    public String toString() {
        return "WorkHome{" +
                "users=" + users +
                ", strings=" + Arrays.toString(strings) +
                ", homeName='" + homeName + '\'' +
                ", user=" + user +
                ", map=" + map +
                ", set=" + set +
                '}';
    }

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public Set<String> getSet() {
        return set;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }
}

