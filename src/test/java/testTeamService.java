import com.cxk.po.Page;
import com.cxk.po.TTeam;
import com.cxk.service.TeamService;
import com.cxk.vo.TeamListVo;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testTeamService {
    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        TeamService bean = (TeamService) applicationContext.getBean("teamServiceImpl");
        TeamListVo teamListVo = new TeamListVo();
        teamListVo.setId(4);
        teamListVo.setPage(new Page());
        teamListVo.getPage().setRow(5);
        teamListVo.getPage().setStart(0);
        List<TTeam> team = bean.findTeamByCompIdByPage(teamListVo);
        System.out.println(teamListVo.getPage().getTotalRecords());
        System.out.println(bean.querySumOfTeam(teamListVo));
    }
}
