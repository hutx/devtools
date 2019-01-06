package cn.jsfund.devtools.service.impl;

import cn.jsfund.devtools.entity.EventBean;
import cn.jsfund.devtools.mapper.EventBeanMapper;
import cn.jsfund.devtools.service.IEventBeanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 事件类信息 服务实现类
 * </p>
 *
 * @author hutx
 * @since 2019-01-05
 */
@Service
public class EventBeanServiceImpl extends ServiceImpl<EventBeanMapper, EventBean> implements IEventBeanService {

}
