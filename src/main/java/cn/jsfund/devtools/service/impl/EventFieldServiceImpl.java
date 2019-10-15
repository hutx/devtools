package cn.jsfund.devtools.service.impl;

import cn.jsfund.devtools.entity.EventField;
import cn.jsfund.devtools.mapper.EventFieldMapper;
import cn.jsfund.devtools.service.IEventFieldService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 事件类字段信息 服务实现类
 * </p>
 *
 * @author hutx
 * @since 2019-01-05
 */
@Service
public class EventFieldServiceImpl extends ServiceImpl<EventFieldMapper, EventField> implements IEventFieldService {

}
