package com.iquantex.devtools.controller;

import com.iquantex.devtools.base.controller.BaseWebController;
import com.iquantex.devtools.base.server.BaseService;
import com.iquantex.devtools.bean.Result;
import com.iquantex.devtools.model.GemfireIndex;
import com.iquantex.devtools.service.GemfireIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hutx on 15:24 2018/11/22
 */
@RestController
@RequestMapping("/api/gemfireIndexs")
public class GemfireIndexController extends BaseWebController<GemfireIndex> {

    @Autowired
    private GemfireIndexService service;

    @Override
    public BaseService<GemfireIndex> getService() {
        return service;
    }

    @GetMapping("/findTableIndex")
    public Result findTableField(@RequestParam(required = true) int baseId, @RequestParam(required = true) String tableName) throws Exception {
        return this.successReturn(service.findTableIndex(baseId, tableName));
    }
}
