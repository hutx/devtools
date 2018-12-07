package cn.jsfund.devtools.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "event_bean")
public class EventBean {
    @Id
    @ColumnType(jdbcType = JdbcType.INTEGER)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "class_name")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String className;

    @Column(name = "class_cn_name")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String classCnName;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String remark;

    @Column(name = "group_id")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer groupId;

    public static final String TABLE = "event_bean";

    public static final String f_id = "id";

    public static final String f_className = "className";

    public static final String f_classCnName = "classCnName";

    public static final String f_remark = "remark";

    public static final String f_groupId = "groupId";

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
     * @return class_name
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className
     */
    public void setClassName(String className) {
        this.className = className == null ? null : className.trim();
    }

    /**
     * @return class_cn_name
     */
    public String getClassCnName() {
        return classCnName;
    }

    /**
     * @param classCnName
     */
    public void setClassCnName(String classCnName) {
        this.classCnName = classCnName == null ? null : classCnName.trim();
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

    /**
     * @return group_id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }
}