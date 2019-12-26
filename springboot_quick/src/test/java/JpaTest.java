import com.dhj.MySpringBootApplication;
import com.dhj.demo.dao.sht.ShtUserRepository;
import com.dhj.demo.pojo.sht.UserSht;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: DHJ
 * @create: 2019/12/12 9:53
 * Description:
 */
@RunWith(SpringRunner.class )
@SpringBootTest(classes = MySpringBootApplication.class)
public class JpaTest {

    @Autowired
    private ShtUserRepository userRepository;
    @Test
    public void jpaTest(){
        List<UserSht> all = userRepository.findAll();
        System.out.println(all);
    }
}
