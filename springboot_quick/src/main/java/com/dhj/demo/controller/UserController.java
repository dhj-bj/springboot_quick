package com.dhj.demo.controller;

import com.dhj.demo.mapper.center.CenterMapper;
import com.dhj.demo.mapper.sht.ShtMapper;
import com.dhj.demo.pojo.center.UserCenter;
import com.dhj.demo.pojo.sht.UserSht;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: DHJ
 * @create: 2019/12/11 10:32
 * Description:
 */
@RestController
public class UserController {

    @Resource
    private ShtMapper shtMapper;
    @Resource
    private CenterMapper centerMapper;

    @RequestMapping("getCenterUser")
    public List<UserCenter> getCenterUser() {
        List<UserCenter> userList = centerMapper.getCenterUser();
        System.out.println(userList);
        return userList;
    }

    @RequestMapping("getShtUser")
    public List<UserSht> getShtUser() {
        List<UserSht> userList = shtMapper.getShtUser();
        System.out.println(userList);
        return userList;
    }

    @RequestMapping("getShtUserById")
    public List<UserSht> getShtUserById() {
        UserSht user = new UserSht();
        user.setId(2);
        List<UserSht> userList = shtMapper.getUserListById(user);
        System.out.println(userList);
        return userList;
    }
}
