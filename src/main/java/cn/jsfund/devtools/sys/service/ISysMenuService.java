package cn.jsfund.devtools.sys.service;

import cn.jsfund.devtools.sys.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu> listMeunByRoleId(Long roleId);

}
