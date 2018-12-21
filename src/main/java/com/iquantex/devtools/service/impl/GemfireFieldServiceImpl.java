package com.iquantex.devtools.service.impl;

import com.iquantex.devtools.base.server.impl.BaseServiceImpl;
import com.iquantex.devtools.common.JdbcConnDB;
import com.iquantex.devtools.mapper.dao.java.GemfireFieldMapper;
import com.iquantex.devtools.model.DatabaseConfig;
import com.iquantex.devtools.model.GemfireField;
import com.iquantex.devtools.service.DatabaseConfigService;
import com.iquantex.devtools.service.GemfireFieldService;
import com.iquantex.devtools.util.SqlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by hutx on 21:35 2018/11/21
 */
@Service
public class GemfireFieldServiceImpl extends BaseServiceImpl<GemfireField> implements GemfireFieldService {

    private static final Logger logger = LoggerFactory.getLogger(GemfireFieldServiceImpl.class);

    @Autowired
    private GemfireFieldMapper mapper;

    @Autowired
    private DatabaseConfigService databaseConfigService;

    public Mapper<GemfireField> getMapper() {
        return mapper;
    }

    @Override
    public List<GemfireField> findTableField(int baseId, String tableName) throws Exception {
        List<GemfireField> fieldList = new ArrayList<>();
        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setId(baseId);
        dbConfig = databaseConfigService.listOne(dbConfig);
        if (DatabaseConfig.c_type_ORACLE.equals(dbConfig.getType())) {
            List<Map<String, Object>> resultSet = JdbcConnDB.findDataDB(dbConfig.getUrl(), dbConfig.getUsername(), dbConfig.getPassword(), SqlUtil.ORACLE_TABLE_COLUMN_SQL, Arrays.asList(tableName, tableName));
            for (Map<String, Object> map : resultSet) {
                GemfireField field = new GemfireField();
                String column= map.get("COLUMN_NAME").toString();
                field.setFieldCode(StringUtil.underlineToCamelhump(column.toLowerCase()));
                field.setFieldName(map.get("COMMENTS") != null ? map.get("COMMENTS").toString() : "");
                int length = Integer.valueOf(map.get("DATA_LENGTH").toString());
                field.setFieldType(SqlUtil.oracleTypeToJava(map.get("DATA_TYPE").toString(), length));
                field.setIsKey(Integer.valueOf(map.get("IS_KEY").toString()));
                field.setIsNull("N".equals(map.get("NULLABLE").toString()) ? 0 : 1);
                fieldList.add(field);
            }
        }
        return fieldList;
    }
}
