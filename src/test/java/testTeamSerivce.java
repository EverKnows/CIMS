import com.cxk.po.TUser;
import com.cxk.service.TeamService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testTeamSerivce {

    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        TeamService service = (TeamService) applicationContext.getBean("teamServiceImpl");
        Integer userId = service.findTeamIdByUserId(31);
        List<TUser> team = service.findUsersBelongYourTeam(1);
        for (TUser tUser : team) {
            System.out.println(tUser.getRealName());
        }

    }
}
