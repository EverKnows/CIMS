import com.cxk.po.TUser;
import com.cxk.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testUserService {
    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userServiceImpl");
        userService.insertUser2Team(18, 2);
    }
}
