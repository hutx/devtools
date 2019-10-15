package cn.jsfund.devtools.sys.mapper;

import cn.jsfund.devtools.sys.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    @Select("SELECT T.* FROM SYS_MENU T ,SYS_RELATION T1 WHERE T.MENU_ID = T1.MENU_ID AND T1.ROLE_ID=#{roleId}")
    List<SysMenu> listMeunByRoleId(@Param("roleId") Long roleId);
}