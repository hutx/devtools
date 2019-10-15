package cn.jsfund.devtools.sys.entity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import cn.jsfund.devtools.base.BaseEntity;
/**
 * <p>
 * 角色和菜单关联表
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
public class SysRelation extends BaseEntity{

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("RELATION_ID")
    private Long relationId;

    /**
     * 菜单id
     */
    @TableField("MENU_ID")
    private Long menuId;

    /**
     * 角色id
     */
    @TableField("ROLE_ID")
    private Long roleId;

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public static final String RELATION_ID = "RELATION_ID";

    public static final String MENU_ID = "MENU_ID";

    public static final String ROLE_ID = "ROLE_ID";

    @Override
    public String toString() {
        return "SysRelation{" +
        ", relationId=" + relationId +
        ", menuId=" + menuId +
        ", roleId=" + roleId +
        "}";
    }
}
