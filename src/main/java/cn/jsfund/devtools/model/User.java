package cn.jsfund.devtools.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "user")
public class User {
    @ColumnType(jdbcType = JdbcType.INTEGER)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String userId;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String name;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String avatar;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String email;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String signature;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String dep;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String tags;

    @Column(name = "notify_count")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer notifyCount;

    @Column(name = "unread_count")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer unreadCount;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String country;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String address;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String phone;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String remark;

    public static final String TABLE = "user";

    public static final String f_id = "id";

    public static final String f_userId = "userId";

    public static final String f_name = "name";

    public static final String f_avatar = "avatar";

    public static final String f_email = "email";

    public static final String f_signature = "signature";

    public static final String f_dep = "dep";

    public static final String f_tags = "tags";

    public static final String f_notifyCount = "notifyCount";

    public static final String f_unreadCount = "unreadCount";

    public static final String f_country = "country";

    public static final String f_address = "address";

    public static final String f_phone = "phone";

    public static final String f_remark = "remark";

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
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
     * @return avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * @return signature
     */
    public String getSignature() {
        return signature;
    }

    /**
     * @param signature
     */
    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    /**
     * @return dep
     */
    public String getDep() {
        return dep;
    }

    /**
     * @param dep
     */
    public void setDep(String dep) {
        this.dep = dep == null ? null : dep.trim();
    }

    /**
     * @return tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * @param tags
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * @return notify_count
     */
    public Integer getNotifyCount() {
        return notifyCount;
    }

    /**
     * @param notifyCount
     */
    public void setNotifyCount(Integer notifyCount) {
        this.notifyCount = notifyCount;
    }

    /**
     * @return unread_count
     */
    public Integer getUnreadCount() {
        return unreadCount;
    }

    /**
     * @param unreadCount
     */
    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}