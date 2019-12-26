import com.dhj.MySpringBootApplication;
import com.dhj.demo.mapper.sht.ShtMapper;
import com.dhj.demo.pojo.center.UserCenter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: DHJ
 * @create: 2019/12/11 12:14
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class MapperTest {

//    @Autowired
//    private ShtMapper shtMapper;
//
//    @Test
//    public void test (){
//        List<UserCenter> userList = shtMapper.getUserList();
//        System.err.println(userList);
//    }
//    @Test
//    public void test2 (){
//        UserCenter user = new UserCenter();
//        user.setId(2);
//        List<UserCenter> userList = shtMapper.getUserListById(user);
//        System.err.println(userList);
//    }

}
