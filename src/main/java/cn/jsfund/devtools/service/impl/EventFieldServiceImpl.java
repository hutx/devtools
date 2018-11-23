package cn.jsfund.devtools.service.impl;

import cn.jsfund.devtools.base.server.impl.BaseServiceImpl;
import cn.jsfund.devtools.mapper.dao.java.EventFieldMapper;
import cn.jsfund.devtools.model.EventField;
import cn.jsfund.devtools.service.EventFieldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by hutx on 15:34 2018/11/22
 */
@Service
public class EventFieldServiceImpl extends BaseServiceImpl<EventField> implements EventFieldService {
    private static final Logger logger = LoggerFactory.getLogger(EventFieldServiceImpl.class);

    @Autowired
    private EventFieldMapper mapper;

    public Mapper<EventField> getMapper() {
        return mapper;
    }
}
