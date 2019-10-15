package cn.jsfund.devtools.sys.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import cn.jsfund.devtools.base.BaseEntity;
/**
 * <p>
 * 登录记录
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
public class SysLoginLog extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "LOGIN_LOG_ID", type = IdType.AUTO)
    private Long loginLogId;

    /**
     * 日志名称
     */
    @TableField("LOG_NAME")
    private String logName;

    /**
     * 管理员id
     */
    @TableField("USER_ID")
    private Long userId;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 是否执行成功
     */
    @TableField("SUCCEED")
    private String succeed;

    /**
     * 具体消息
     */
    @TableField("MESSAGE")
    private String message;

    /**
     * 登录ip
     */
    @TableField("IP_ADDRESS")
    private String ipAddress;

    public Long getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(Long loginLogId) {
        this.loginLogId = loginLogId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSucceed() {
        return succeed;
    }

    public void setSucceed(String succeed) {
        this.succeed = succeed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public static final String LOGIN_LOG_ID = "LOGIN_LOG_ID";

    public static final String LOG_NAME = "LOG_NAME";

    public static final String USER_ID = "USER_ID";

    public static final String CREATE_TIME = "CREATE_TIME";

    public static final String SUCCEED = "SUCCEED";

    public static final String MESSAGE = "MESSAGE";

    public static final String IP_ADDRESS = "IP_ADDRESS";

    @Override
    public String toString() {
        return "SysLoginLog{" +
        ", loginLogId=" + loginLogId +
        ", logName=" + logName +
        ", userId=" + userId +
        ", createTime=" + createTime +
        ", succeed=" + succeed +
        ", message=" + message +
        ", ipAddress=" + ipAddress +
        "}";
    }
}
