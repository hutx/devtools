package cn.jsfund.devtools.controller;

import cn.jsfund.devtools.base.server.BaseService;
import cn.jsfund.devtools.bean.GemfireBeans;
import cn.jsfund.devtools.bean.Result;
import cn.jsfund.devtools.model.GemfireBean;
import cn.jsfund.devtools.service.GemfireBeanService;
import cn.jsfund.devtools.base.controller.BaseWebController;
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
