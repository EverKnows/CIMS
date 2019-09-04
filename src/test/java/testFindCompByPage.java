import com.cxk.po.TComp;
import com.cxk.service.CompService;
import com.cxk.vo.CompListVo;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testFindCompByPage {
    @Test
    public void test() throws Exception {
        CompListVo vo = new CompListVo();
       // vo.setLevel("school");
        //vo.setTime("signup");
        vo.setOrder("new");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        CompService bean = (CompService) applicationContext.getBean("compServiceImpl");
        CompListVo vo1 = bean.findCompByPage(vo);
        System.out.println(vo1.getPage().getTotalRecords());
        List<TComp> list = vo1.getCompList();
        for (TComp tComp : list) {
            System.out.println(tComp.getCompName());
            System.out.println(tComp.getLevel());
        }

    }
}
