package com.dhj.demo.mapper.sht;

import com.dhj.demo.pojo.center.UserCenter;
import com.dhj.demo.pojo.sht.UserSht;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: DHJ
 * @create: 2019/12/11 10:44
 * Description:
 */

@Mapper
public interface ShtMapper {
    List<UserSht> getShtUser();
    List<UserSht> getUserListById(UserSht user);
}
