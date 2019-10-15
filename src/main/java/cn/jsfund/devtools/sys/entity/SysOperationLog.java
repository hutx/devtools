package cn.jsfund.devtools.sys.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import cn.jsfund.devtools.base.BaseEntity;
/**
 * <p>
 * 操作日志
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
public class SysOperationLog extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "OPERATION_LOG_ID", type = IdType.AUTO)
    private Long operationLogId;

    /**
     * 日志类型(字典)
     */
    @TableField("LOG_TYPE")
    private String logType;

    /**
     * 日志名称
     */
    @TableField("LOG_NAME")
    private String logName;

    /**
     * 用户id
     */
    @TableField("USER_ID")
    private Long userId;

    /**
     * 类名称
     */
    @TableField("CLASS_NAME")
    private String className;

    /**
     * 方法名称
     */
    @TableField("METHOD")
    private String method;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 是否成功(字典)
     */
    @TableField("SUCCEED")
    private String succeed;

    /**
     * 备注
     */
    @TableField("MESSAGE")
    private String message;

    public Long getOperationLogId() {
        return operationLogId;
    }

    public void setOperationLogId(Long operationLogId) {
        this.operationLogId = operationLogId;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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

    public static final String OPERATION_LOG_ID = "OPERATION_LOG_ID";

    public static final String LOG_TYPE = "LOG_TYPE";

    public static final String LOG_NAME = "LOG_NAME";

    public static final String USER_ID = "USER_ID";

    public static final String CLASS_NAME = "CLASS_NAME";

    public static final String METHOD = "METHOD";

    public static final String CREATE_TIME = "CREATE_TIME";

    public static final String SUCCEED = "SUCCEED";

    public static final String MESSAGE = "MESSAGE";

    @Override
    public String toString() {
        return "SysOperationLog{" +
        ", operationLogId=" + operationLogId +
        ", logType=" + logType +
        ", logName=" + logName +
        ", userId=" + userId +
        ", className=" + className +
        ", method=" + method +
        ", createTime=" + createTime +
        ", succeed=" + succeed +
        ", message=" + message +
        "}";
    }
}
