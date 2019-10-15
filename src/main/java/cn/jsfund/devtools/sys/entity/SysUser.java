package cn.jsfund.devtools.sys.entity;
import cn.jsfund.devtools.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.Date;
/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
public class SysUser extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId("USER_ID")
    private Long userId;

    /**
     * 头像
     */
    @TableField("AVATAR")
    private String avatar;

    /**
     * 账号
     */
    @TableField("ACCOUNT")
    private String account;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * md5密码盐
     */
    @TableField("SALT")
    private String salt;

    /**
     * 名字
     */
    @TableField("NAME")
    private String name;

    /**
     * 生日
     */
    @TableField("BIRTHDAY")
    private Date birthday;

    /**
     * 性别(字典)
     */
    @TableField("SEX")
    private String sex;

    /**
     * 电子邮件
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 电话
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 角色id(多个逗号隔开)
     */
    @TableField("ROLE_ID")
    private String roleId;

    /**
     * 部门id(多个逗号隔开)
     */
    @TableField("DEPT_ID")
    private Long deptId;

    /**
     * 状态(字典)
     */
    @TableField("STATUS")
    private String status;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 创建人
     */
    @TableField("CREATE_USER")
    private Long createUser;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * 更新人
     */
    @TableField("UPDATE_USER")
    private Long updateUser;

    /**
     * 乐观锁
     */
    @TableField("VERSION")
    private Integer version;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public static final String USER_ID = "USER_ID";

    public static final String AVATAR = "AVATAR";

    public static final String ACCOUNT = "ACCOUNT";

    public static final String PASSWORD = "PASSWORD";

    public static final String SALT = "SALT";

    public static final String NAME = "NAME";

    public static final String BIRTHDAY = "BIRTHDAY";

    public static final String SEX = "SEX";

    public static final String EMAIL = "EMAIL";

    public static final String PHONE = "PHONE";

    public static final String ROLE_ID = "ROLE_ID";

    public static final String DEPT_ID = "DEPT_ID";

    public static final String STATUS = "STATUS";

    public static final String CREATE_TIME = "CREATE_TIME";

    public static final String CREATE_USER = "CREATE_USER";

    public static final String UPDATE_TIME = "UPDATE_TIME";

    public static final String UPDATE_USER = "UPDATE_USER";

    public static final String VERSION = "VERSION";

    @Override
    public String toString() {
        return "SysUser{" +
        ", userId=" + userId +
        ", avatar=" + avatar +
        ", account=" + account +
        ", password=" + password +
        ", salt=" + salt +
        ", name=" + name +
        ", birthday=" + birthday +
        ", sex=" + sex +
        ", email=" + email +
        ", phone=" + phone +
        ", roleId=" + roleId +
        ", deptId=" + deptId +
        ", status=" + status +
        ", createTime=" + createTime +
        ", createUser=" + createUser +
        ", updateTime=" + updateTime +
        ", updateUser=" + updateUser +
        ", version=" + version +
        "}";
    }
}
