package cn.jsfund.devtools.service.impl;

import cn.jsfund.devtools.entity.EventGroup;
import cn.jsfund.devtools.mapper.EventGroupMapper;
import cn.jsfund.devtools.service.IEventGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 事件分组 服务实现类
 * </p>
 *
 * @author hutx
 * @since 2019-01-05
 */
@Service
public class EventGroupServiceImpl extends ServiceImpl<EventGroupMapper, EventGroup> implements IEventGroupService {

}
