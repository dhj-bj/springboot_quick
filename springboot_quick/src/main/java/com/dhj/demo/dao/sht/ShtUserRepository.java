package com.dhj.demo.dao.sht;

import com.dhj.demo.pojo.sht.UserSht;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: DHJ
 * @create: 2019/12/12 10:18
 * Description:
 */
public interface ShtUserRepository extends JpaRepository<UserSht,Long> {

}
