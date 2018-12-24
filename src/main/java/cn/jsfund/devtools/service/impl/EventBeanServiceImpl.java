package cn.jsfund.devtools.service.impl;

import cn.jsfund.devtools.base.server.impl.BaseServiceImpl;
import cn.jsfund.devtools.service.EventBeanService;
import cn.jsfund.devtools.mapper.dao.java.EventBeanMapper;
import cn.jsfund.devtools.model.EventBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by hutx on 15:34 2018/11/22
 */
@Service
public class EventBeanServiceImpl extends BaseServiceImpl<EventBean> implements EventBeanService {
    private static final Logger logger = LoggerFactory.getLogger(EventBeanServiceImpl.class);

    @Autowired
    private EventBeanMapper mapper;

    public Mapper<EventBean> getMapper() {
        return mapper;
    }
}
