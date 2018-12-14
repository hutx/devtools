package cn.jsfund.devtools.controller;

import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.base.server.BaseService;
import cn.jsfund.devtools.bean.Result;
import cn.jsfund.devtools.model.GemfireField;
import cn.jsfund.devtools.service.GemfireFieldService;
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
