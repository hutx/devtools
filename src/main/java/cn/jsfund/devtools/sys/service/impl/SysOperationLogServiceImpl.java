package cn.jsfund.devtools.sys.service.impl;

import cn.jsfund.devtools.sys.entity.SysOperationLog;
import cn.jsfund.devtools.sys.mapper.SysOperationLogMapper;
import cn.jsfund.devtools.sys.service.ISysOperationLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
@Service
public class SysOperationLogServiceImpl extends ServiceImpl<SysOperationLogMapper, SysOperationLog> implements ISysOperationLogService {

}
