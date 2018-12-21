package com.iquantex.devtools.controller;

import com.iquantex.devtools.base.controller.BaseWebController;
import com.iquantex.devtools.base.server.BaseService;
import com.iquantex.devtools.model.DatabaseConfig;
import com.iquantex.devtools.service.DatabaseConfigService;
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
