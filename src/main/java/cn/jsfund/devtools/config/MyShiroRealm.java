package cn.jsfund.devtools.config;

import cn.jsfund.devtools.sys.entity.SysMenu;
import cn.jsfund.devtools.sys.entity.SysRole;
import cn.jsfund.devtools.sys.entity.SysUser;
import cn.jsfund.devtools.sys.service.ISysMenuService;
import cn.jsfund.devtools.sys.service.ISysRelationService;
import cn.jsfund.devtools.sys.service.ISysRoleService;
import cn.jsfund.devtools.sys.service.ISysUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.*;

public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private ISysRoleService roleService;
    @Resource
    private ISysRelationService relationService;
    @Resource
    private ISysMenuService menuService;
    @Resource
    private ISysUserService userService;


    /**
     * 权限认证
     *
     * @param principal
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
        SysUser user = (SysUser) principal.getPrimaryPrincipal();
        QueryWrapper<SysRole> qw = new QueryWrapper<>();
        qw.setEntity(new SysRole());
        qw.in(SysRole.ROLE_ID, Arrays.asList(user.getRoleId().split(",")));
        List<SysRole> roleList = roleService.list(qw);
        List<SysMenu> menuList = new ArrayList<>();
        for (SysRole role : roleList) {
            authenticationInfo.addRole(role.getName());
            menuList.addAll(menuService.listMeunByRoleId(role.getRoleId()));
        }
        Set<SysMenu> menuSet = new HashSet<>(menuList);
        menuList.addAll(menuSet);
        for (SysMenu menu : menuList) {
            authenticationInfo.addStringPermission(menu.getUrl());
        }
        return authenticationInfo;
    }

    /**
     * 登录认证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        SysUser user = new SysUser();
        user.setAccount(username);
        user = userService.getOne(new QueryWrapper<>(user));
        if (user == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        return authenticationInfo;
    }
}
