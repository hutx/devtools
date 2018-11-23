package cn.jsfund.devtools.service.impl;

import cn.jsfund.devtools.base.server.impl.BaseServiceImpl;
import cn.jsfund.devtools.mapper.dao.java.DatabaseConfigMapper;
import cn.jsfund.devtools.model.DatabaseConfig;
import cn.jsfund.devtools.service.DatabaseConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by hutx on 15:44 2018/11/22
 */
@Service
public class DatabaseConfigServiceImpl extends BaseServiceImpl<DatabaseConfig> implements DatabaseConfigService {
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfigServiceImpl.class);

    @Autowired
    private DatabaseConfigMapper mapper;

    public Mapper<DatabaseConfig> getMapper() {
        return mapper;
    }


}
