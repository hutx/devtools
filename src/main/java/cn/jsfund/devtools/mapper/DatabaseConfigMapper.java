package cn.jsfund.devtools.mapper;

import cn.jsfund.devtools.entity.DatabaseConfig;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 数据库配置 Mapper 接口
 * </p>
 *
 * @author hutx
 * @since 2019-01-13
 */
public interface DatabaseConfigMapper extends BaseMapper<DatabaseConfig> {

//    @Select("select * from database_config ${ew.customSqlSegment}")
    IPage<DatabaseConfig> selectPages(IPage<DatabaseConfig> page, @Param("type") String type);

}
