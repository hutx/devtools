package cn.jsfund.devtools.controller;


import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.entity.EventGroup;
import cn.jsfund.devtools.service.IEventGroupService;
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
@RequestMapping("event-group")
public class EventGroupController extends BaseWebController<IEventGroupService,EventGroup> {

//    @Autowired
//    private IEventGroupService service;
//
//    @Override
//    public IService<EventGroup> getService() {
//        return service;
//    }

}
