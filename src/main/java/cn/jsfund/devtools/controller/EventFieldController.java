package cn.jsfund.devtools.controller;


import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.entity.EventField;
import cn.jsfund.devtools.service.IEventFieldService;
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
@RequestMapping("event-field")
public class EventFieldController extends BaseWebController<IEventFieldService, EventField> {

//    @Autowired
//    private IEventFieldService service;
//
//    @Override
//    public IService<EventField> getService() {
//        return service;
//    }

}
