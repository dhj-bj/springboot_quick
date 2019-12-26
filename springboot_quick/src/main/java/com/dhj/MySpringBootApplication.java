package com.dhj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author: DHJ
 * @create: 2019/12/10 10:39
 * Description:
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MySpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySpringBootApplication.class);
    }
}
