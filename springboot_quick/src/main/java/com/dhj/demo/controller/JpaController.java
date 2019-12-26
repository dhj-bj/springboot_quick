package com.dhj.demo.controller;

import com.dhj.demo.dao.center.CenterUserRepository;
import com.dhj.demo.dao.sht.ShtUserRepository;
import com.dhj.demo.pojo.center.UserCenter;
import com.dhj.demo.pojo.sht.UserSht;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: DHJ
 * @create: 2019/12/12 14:47
 * Description:
 */
@RestController
public class JpaController {

    @Autowired
    private CenterUserRepository centerUserRepository;
    @Autowired
    private ShtUserRepository shtUserRepository;

    @RequestMapping("getJpaCenterUser")
    public List<UserCenter> getJpaCenterUser() {
        List<UserCenter> all = centerUserRepository.findAll();
        System.out.println(all);
        return all;
    }

    @RequestMapping("getJpaShtUser")
    public List<UserSht> getJpaShtUser() {
        List<UserSht> all = shtUserRepository.findAll();
        System.out.println(all);
        return all;
    }
}
