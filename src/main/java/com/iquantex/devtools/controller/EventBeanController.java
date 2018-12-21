package com.iquantex.devtools.controller;

import com.iquantex.devtools.base.controller.BaseWebController;
import com.iquantex.devtools.base.server.BaseService;
import com.iquantex.devtools.model.EventBean;
import com.iquantex.devtools.service.EventBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hutx on 15:37 2018/11/22
 */
@RestController
@RequestMapping("/api/eventBeans")
public class EventBeanController extends BaseWebController<EventBean> {

    @Autowired
    private EventBeanService service;

    @Override
    public BaseService<EventBean> getService() {
        return service;
    }
}
