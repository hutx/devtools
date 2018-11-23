package cn.jsfund.devtools.controller;

import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.model.GemfireBean;
import cn.jsfund.devtools.base.server.BaseService;
import cn.jsfund.devtools.service.GemfireBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hutx on 21:44 2018/11/21
 */
@RestController
@RequestMapping("/api/gemfireBeans")
public class GemfireBeanController extends BaseWebController<GemfireBean> {

    @Autowired
    private GemfireBeanService service;

    @Override
    public BaseService<GemfireBean> getService() {
        return service;
    }
}
