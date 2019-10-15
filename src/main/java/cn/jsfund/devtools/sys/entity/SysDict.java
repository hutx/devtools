package cn.jsfund.devtools.sys.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import cn.jsfund.devtools.base.BaseEntity;
/**
 * <p>
 * 字典表
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
public class SysDict extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "DICT_ID", type = IdType.AUTO)
    private Long dictId;

    /**
     * 父级字典id
     */
    @TableField("PID")
    private Long pid;

    /**
     * 字典名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 字典的编码
     */
    @TableField("CODE")
    private String code;

    /**
     * 字典描述
     */
    @TableField("DESCRIPTION")
    private String description;

    /**
     * 排序
     */
    @TableField("SORT")
    private Integer sort;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * 创建人
     */
    @TableField("CREATE_USER")
    private Long createUser;

    /**
     * 修改人
     */
    @TableField("UPDATE_USER")
    private Long updateUser;

    public Long getDictId() {
        return dictId;
    }

    public void setDictId(Long dictId) {
        this.dictId = dictId;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public static final String DICT_ID = "DICT_ID";

    public static final String PID = "PID";

    public static final String NAME = "NAME";

    public static final String CODE = "CODE";

    public static final String DESCRIPTION = "DESCRIPTION";

    public static final String SORT = "SORT";

    public static final String CREATE_TIME = "CREATE_TIME";

    public static final String UPDATE_TIME = "UPDATE_TIME";

    public static final String CREATE_USER = "CREATE_USER";

    public static final String UPDATE_USER = "UPDATE_USER";

    @Override
    public String toString() {
        return "SysDict{" +
        ", dictId=" + dictId +
        ", pid=" + pid +
        ", name=" + name +
        ", code=" + code +
        ", description=" + description +
        ", sort=" + sort +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", createUser=" + createUser +
        ", updateUser=" + updateUser +
        "}";
    }
}
