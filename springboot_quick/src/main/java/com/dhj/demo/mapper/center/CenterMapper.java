package com.dhj.demo.mapper.center;

import com.dhj.demo.pojo.center.UserCenter;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author: DHJ
 * @create: 2019/12/11 14:57
 * Description:
 */
@Mapper
public interface CenterMapper {
    List<UserCenter> getCenterUser();
}
