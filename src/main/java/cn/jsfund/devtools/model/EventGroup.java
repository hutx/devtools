package cn.jsfund.devtools.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "event_group")
public class EventGroup {
    @ColumnType(jdbcType = JdbcType.INTEGER)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "group_name")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String groupName;

    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String remark;

    public static final String TABLE = "event_group";

    public static final String f_id = "id";

    public static final String f_groupName = "groupName";

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
     * @return group_name
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName == null ? null : groupName.trim();
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