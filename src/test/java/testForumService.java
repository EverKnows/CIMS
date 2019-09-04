import com.cxk.po.TTopic;
import com.cxk.service.ForumService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class testForumService {
    @Test
    public void test() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        ForumService bean = (ForumService) applicationContext.getBean("forumServiceImpl");
        List<TTopic> topic = bean.findAllTopicByBoardId(2);
        for (TTopic tTopic : topic) {
            System.out.println(tTopic.getTopicText());
        }
    }
}
