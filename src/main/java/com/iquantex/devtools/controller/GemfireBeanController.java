package com.iquantex.devtools.controller;

import com.iquantex.devtools.base.controller.BaseWebController;
import com.iquantex.devtools.bean.GemfireBeans;
import com.iquantex.devtools.bean.Result;
import com.iquantex.devtools.model.GemfireBean;
import com.iquantex.devtools.base.server.BaseService;
import com.iquantex.devtools.service.GemfireBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/fieldInfo")
    public Result fieldInfo(@RequestParam(required = false, defaultValue = "1") Integer classId) {
        try {
            return this.successReturn(service.findBeanFieldInfoByClassId(classId));
        } catch (Exception var4) {
            return this.successReturn();
        }
    }

    @PostMapping("/saveField")
    public Result addFieldInfo(@RequestBody GemfireBeans beans) {
        try {
            service.saveBeanFieldInfo(beans.getClassId(), beans.getFieldList(), beans.getIndexList());
            return this.successReturn();
        } catch (Exception var4) {
            return this.successReturn();
        }
    }
}
