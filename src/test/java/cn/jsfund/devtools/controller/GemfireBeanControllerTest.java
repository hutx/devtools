package cn.jsfund.devtools.controller;

import cn.jsfund.devtools.entity.DatabaseConfig;
import cn.jsfund.devtools.mapper.DatabaseConfigMapper;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Autowired
    private DatabaseConfigMapper databaseConfigMapper;

    @Test
    public void contextLoads() {
        IPage<DatabaseConfig> page = new Page<>(1, 10);
        page = databaseConfigMapper.selectPage(page, new QueryWrapper<DatabaseConfig>());
        logger.info("list1<{}>", JSONObject.toJSONString(page));
        IPage<DatabaseConfig> page1 = new Page<>(1, 10);
        page = databaseConfigMapper.selectPages(page, "oracle");
        logger.info("list<{}>", JSONObject.toJSONString(page));
//        GemfireBean gemfireBean = new GemfireBean();
//        gemfireBean.setClassCnName("fdsf");
//        gemfireBean.setClassName("dd");
        /*Result result = gemfireBeanController.add(gemfireBean);
        logger.info("result:<{}> ", result);
        gemfireBean.setId(1);
       // result = gemfireBeanController.delete(gemfireBean);
        logger.info("result:<{}> ", result);*/

    }

}