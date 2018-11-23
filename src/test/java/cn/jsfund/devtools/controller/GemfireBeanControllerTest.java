package cn.jsfund.devtools.controller;

import cn.jsfund.devtools.bean.Result;
import cn.jsfund.devtools.model.GemfireBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by hutx on 9:49 2018/11/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GemfireBeanControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(GemfireBeanControllerTest.class);
    @Autowired
    private GemfireBeanController gemfireBeanController;

    @Test
    public void contextLoads() {
        GemfireBean gemfireBean = new GemfireBean();
        gemfireBean.setClassCnName("fdsf");
        gemfireBean.setClassName("dd");
        Result result = gemfireBeanController.add(gemfireBean);
        logger.info("result:<{}> ", result);
        gemfireBean.setId(1);
        result = gemfireBeanController.delete(gemfireBean);
        logger.info("result:<{}> ", result);

    }

}