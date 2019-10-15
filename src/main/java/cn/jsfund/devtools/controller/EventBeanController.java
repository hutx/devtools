package cn.jsfund.devtools.controller;


import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.entity.EventBean;
import cn.jsfund.devtools.service.IEventBeanService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hutx
 * @since 2019-01-05
 */
@RestController
@RequestMapping("event-bean")
public class EventBeanController extends BaseWebController<IEventBeanService,EventBean> {

//    @Autowired
//    private IEventBeanService service;
//
//    @Override
//    public IService<EventBean> getService() {
//        return service;
//    }

}
