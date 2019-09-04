import com.cxk.po.TComp;
import com.cxk.service.CompService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testCompService {
    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        CompService service = (CompService) applicationContext.getBean("compServiceImpl");
        List<TComp> compInfo = service.findAllCompInfo();
        for (TComp tComp : compInfo) {
            System.out.println(tComp.getIntroducation());
        }
    }
}
