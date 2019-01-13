package cn.jsfund.devtools.service.impl;

import cn.jsfund.devtools.entity.DatabaseConfig;
import cn.jsfund.devtools.mapper.DatabaseConfigMapper;
import cn.jsfund.devtools.service.IDatabaseConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 数据库配置 服务实现类
 * </p>
 *
 * @author hutx
 * @since 2019-01-13
 */
@Service
public class DatabaseConfigServiceImpl extends ServiceImpl<DatabaseConfigMapper, DatabaseConfig> implements IDatabaseConfigService {

}
