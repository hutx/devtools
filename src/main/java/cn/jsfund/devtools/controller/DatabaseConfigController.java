package cn.jsfund.devtools.controller;

import cn.jsfund.devtools.base.server.BaseService;
import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.model.DatabaseConfig;
import cn.jsfund.devtools.service.DatabaseConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hutx on 15:37 2018/11/22
 */
@RestController
@RequestMapping("/api/databaseConfigs")
public class DatabaseConfigController extends BaseWebController<DatabaseConfig> {

    @Autowired
    private DatabaseConfigService service;

    @Override
    public BaseService<DatabaseConfig> getService() {
        return service;
    }
}
