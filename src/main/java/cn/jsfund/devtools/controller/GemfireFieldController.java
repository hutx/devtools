package cn.jsfund.devtools.controller;


import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.entity.GemfireField;
import cn.jsfund.devtools.service.IGemfireFieldService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author hutx
 * @since 2019-01-05
 */
@RestController
@RequestMapping("gemfire-field")
public class GemfireFieldController extends BaseWebController<IGemfireFieldService, GemfireField> {

//    @Autowired
//    private IGemfireFieldService service;
//
//    @Override
//    public IService<GemfireField> getService() {
//        return service;
//    }
}
