package cn.jsfund.devtools.sys.service.impl;

import cn.jsfund.devtools.sys.entity.SysUser;
import cn.jsfund.devtools.sys.mapper.SysUserMapper;
import cn.jsfund.devtools.sys.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
