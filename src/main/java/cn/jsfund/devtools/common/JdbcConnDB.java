package cn.jsfund.devtools.common;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hutx on 16:35 2018/11/22
 */
public class JdbcConnDB {
    private static final Logger logger = LoggerFactory.getLogger(JdbcConnDB.class);

    /**
     * @param url
     * @param username
     * @param password
     * @param sql
     * @param params
     * @return
     */
    public static List<Map<String, Object>> findDataDB(String url, String username, String password, String sql, List<Object> params) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Map<String, Object>> resultList = new ArrayList<>();
        try {
            logger.info("JDBC数据源信息数据库用户：<{}>, 密码：<{}>, URL:<{}>", username, password, url);
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < params.size(); i++) {
                if (params.get(i).getClass().getTypeName().equals(String.class.getTypeName())) {
                    ps.setString(i + 1, (String) params.get(i));
                }
            }
            logger.info("SQL:{}", sql);
            logger.info("params:<{}>", StringUtils.join(params, ","));
            resultSet = ps.executeQuery();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    String columnLabel = rsmd.getColumnLabel(i);
                    map.put(columnLabel, resultSet.getObject(columnLabel));
                }
                resultList.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != ps) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != conn) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return resultList;
    }
}
