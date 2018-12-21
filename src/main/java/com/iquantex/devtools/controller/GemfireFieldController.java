package com.iquantex.devtools.controller;

import com.iquantex.devtools.base.controller.BaseWebController;
import com.iquantex.devtools.base.server.BaseService;
import com.iquantex.devtools.bean.Result;
import com.iquantex.devtools.model.GemfireField;
import com.iquantex.devtools.service.GemfireFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hutx on 21:44 2018/11/21
 */
@RestController
@RequestMapping("/api/gemfireFields")
public class GemfireFieldController extends BaseWebController<GemfireField> {

    @Autowired
    private GemfireFieldService service;

    @Override
    public BaseService<GemfireField> getService() {
        return service;
    }

    @GetMapping({"/findTableField"})
    public Result findTableField(@RequestParam(required = true) int baseId, @RequestParam(required = true) String tableName) throws Exception {
        return this.successReturn(service.findTableField(baseId, tableName));
    }
}
