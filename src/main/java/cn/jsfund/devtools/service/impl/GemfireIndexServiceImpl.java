package cn.jsfund.devtools.service.impl;

import cn.jsfund.devtools.base.server.impl.BaseServiceImpl;
import cn.jsfund.devtools.mapper.dao.java.GemfireIndexMapper;
import cn.jsfund.devtools.service.DatabaseConfigService;
import cn.jsfund.devtools.service.GemfireIndexService;
import cn.jsfund.devtools.common.JdbcConnDB;
import cn.jsfund.devtools.model.DatabaseConfig;
import cn.jsfund.devtools.model.GemfireIndex;
import cn.jsfund.devtools.util.SqlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by hutx on 15:20 2018/11/22
 */
@Service
public class GemfireIndexServiceImpl extends BaseServiceImpl<GemfireIndex> implements GemfireIndexService {
    private static final Logger logger = LoggerFactory.getLogger(GemfireBeanServiceImpl.class);

    @Autowired
    private GemfireIndexMapper gemfireIndexMapper;

    @Autowired
    private DatabaseConfigService databaseConfigService;

    public Mapper<GemfireIndex> getMapper() {
        return gemfireIndexMapper;
    }

    @Override
    public List<GemfireIndex> findTableIndex(int baseId, String tableName) throws Exception {
        List<GemfireIndex> fieldList = new ArrayList<>();
        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setId(baseId);
        dbConfig = databaseConfigService.listOne(dbConfig);
        if (DatabaseConfig.c_type_ORACLE.equals(dbConfig.getType())) {
            List<Map<String, Object>> resultSet = JdbcConnDB.findDataDB(dbConfig.getUrl(), dbConfig.getUsername(), dbConfig.getPassword(), SqlUtil.ORACLE_TABLE_INDEX_SQL, Arrays.asList(tableName));
            for (Map<String, Object> map : resultSet) {
                GemfireIndex index = new GemfireIndex();
                index.setFieldCode(map.get("INDEX_COLUMN").toString());
                fieldList.add(index);
            }
        }
        return fieldList;
    }
}
