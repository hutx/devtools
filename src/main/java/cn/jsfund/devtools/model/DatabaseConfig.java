package cn.jsfund.devtools.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;


@Table(name = "database_config")
public class DatabaseConfig {
    @ColumnType(jdbcType = JdbcType.INTEGER)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String name;

    /**
     * 数据库类型<>ORACLE=oracle=ORACLE&MYSQL=mysql=MYSQL
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String type;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String url;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String username;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String password;

    public static final String TABLE = "database_config";

    public static final String f_id = "id";

    public static final String f_name = "name";

    public static final String f_type = "type";

    public static final String f_url = "url";

    public static final String f_username = "username";

    public static final String f_password = "password";

    /**
     * ORACLE
     */
    public static final String c_type_ORACLE = "oracle";

    /**
     * MYSQL
     */
    public static final String c_type_MYSQL = "mysql";

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取数据库类型<>ORACLE=oracle=ORACLE&MYSQL=mysql=MYSQL
     *
     * @return type - 数据库类型<>ORACLE=oracle=ORACLE&MYSQL=mysql=MYSQL
     */
    public String getType() {
        return type;
    }

    /**
     * 设置数据库类型<>ORACLE=oracle=ORACLE&MYSQL=mysql=MYSQL
     *
     * @param type 数据库类型<>ORACLE=oracle=ORACLE&MYSQL=mysql=MYSQL
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}