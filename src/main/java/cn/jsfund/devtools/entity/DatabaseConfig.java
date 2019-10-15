package cn.jsfund.devtools.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import cn.jsfund.devtools.base.BaseEntity;
/**
 * <p>
 * 数据库配置
 * </p>
 *
 * @author hutx
 * @since 2019-01-13
 */
public class DatabaseConfig extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    /**
     * 数据库类型<>ORACLE=oracle=ORACLE&MYSQL=mysql=MYSQL
     */
    private String type;

    private String url;

    private String username;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String TYPE = "type";

    public static final String URL = "url";

    public static final String USERNAME = "username";

    public static final String PASSWORD = "password";

    @Override
    public String toString() {
        return "DatabaseConfig{" +
        ", id=" + id +
        ", name=" + name +
        ", type=" + type +
        ", url=" + url +
        ", username=" + username +
        ", password=" + password +
        "}";
    }
}
