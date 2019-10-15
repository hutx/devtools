package cn.jsfund.devtools.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import cn.jsfund.devtools.base.BaseEntity;
/**
 * <p>
 * 事件分组
 * </p>
 *
 * @author hutx
 * @since 2019-01-05
 */
public class EventGroup extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String groupName;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static final String ID = "id";

    public static final String GROUP_NAME = "group_name";

    public static final String REMARK = "remark";

    @Override
    public String toString() {
        return "EventGroup{" +
        ", id=" + id +
        ", groupName=" + groupName +
        ", remark=" + remark +
        "}";
    }
}
