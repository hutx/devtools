package cn.jsfund.devtools.controller;

import cn.jsfund.devtools.base.server.BaseService;
import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.model.EventField;
import cn.jsfund.devtools.service.EventFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hutx on 15:37 2018/11/22
 */
@RestController
@RequestMapping("/api/eventFields")
public class EventFieldController extends BaseWebController<EventField> {

    @Autowired
    private EventFieldService service;

    @Override
    public BaseService<EventField> getService() {
        return service;
    }
}
