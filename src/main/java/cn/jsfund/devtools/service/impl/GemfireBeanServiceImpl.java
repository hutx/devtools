package cn.jsfund.devtools.service.impl;

import cn.jsfund.devtools.base.server.impl.BaseServiceImpl;
import cn.jsfund.devtools.mapper.dao.java.GemfireBeanMapper;
import cn.jsfund.devtools.model.GemfireBean;
import cn.jsfund.devtools.service.GemfireBeanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by hutx on 21:35 2018/11/21
 */
@Service
public class GemfireBeanServiceImpl extends BaseServiceImpl<GemfireBean> implements GemfireBeanService {

    private static final Logger logger = LoggerFactory.getLogger(GemfireBeanServiceImpl.class);

    @Autowired
    private GemfireBeanMapper gemfireBeanMapper;

    public Mapper<GemfireBean> getMapper() {
        return gemfireBeanMapper;
    }
}
