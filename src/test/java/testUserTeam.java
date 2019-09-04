import com.cxk.po.TUser;
import com.cxk.service.TeamService;
import com.cxk.service.UserService;
import com.cxk.vo.JoinTeamVo;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testUserTeam {
    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        UserService service =  (UserService) applicationContext.getBean("userServiceImpl");
        JoinTeamVo joinTeamVo = new JoinTeamVo();
        joinTeamVo.setId(1);
        joinTeamVo.setUser(new TUser());
        joinTeamVo.getUser().setId(7);
        Integer team = service.findUserJoinTeam(joinTeamVo.getUser());
        System.out.println(team);
    }
}
