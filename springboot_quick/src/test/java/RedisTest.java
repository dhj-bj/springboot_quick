import com.alibaba.druid.util.StringUtils;
import com.dhj.MySpringBootApplication;
import com.dhj.demo.dao.center.CenterUserRepository;
import com.dhj.demo.dao.sht.ShtUserRepository;
import com.dhj.demo.pojo.sht.UserSht;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLRecoverableException;
import java.util.List;

/**
 * @author: DHJ
 * @create: 2019/12/12 14:57
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class RedisTest {

    @Autowired
    private CenterUserRepository centerUserRepository;
    @Autowired
    private ShtUserRepository shtUserRepository;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() throws JsonProcessingException {
        //从redis缓存中获得指定的数据
        String userDataList = redisTemplate.boundValueOps("users.findAll").get();
        //如果redis中没有数据的话
        if (StringUtils.isEmpty(userDataList)) {
            //查询数据库获得数据
            List<UserSht> all = shtUserRepository.findAll();
            //转换成json格式字符串
            ObjectMapper om = new ObjectMapper();
            userDataList = om.writeValueAsString(all);
            // 将数据存储到redis中，下次在查询直接从redis中获得数据，不用在查询数据库
            redisTemplate.boundValueOps("users.findAll").set(userDataList);
            System.err.println("在数据库中获取数据，并存储到redis》》》》》》》》》》》》");
            System.out.println(userDataList);
        } else {
            System.err.println("在reids中获取数据+++++》》》》》》》》》》》");
            System.out.println(userDataList);
        }
    }
}
