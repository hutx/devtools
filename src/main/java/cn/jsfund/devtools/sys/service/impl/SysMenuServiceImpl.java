package cn.jsfund.devtools.sys.service.impl;

import cn.jsfund.devtools.sys.entity.SysMenu;
import cn.jsfund.devtools.sys.mapper.SysMenuMapper;
import cn.jsfund.devtools.sys.service.ISysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List<SysMenu> listMeunByRoleId(Long roleId) {
        return baseMapper.listMeunByRoleId(roleId);
    }
}
