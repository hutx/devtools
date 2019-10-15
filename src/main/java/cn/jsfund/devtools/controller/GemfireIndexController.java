package cn.jsfund.devtools.controller;


import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.entity.GemfireIndex;
import cn.jsfund.devtools.service.IGemfireIndexService;
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
@RequestMapping("gemfire-index")
public class GemfireIndexController extends BaseWebController<IGemfireIndexService,GemfireIndex> {

//    @Autowired
//    private IGemfireIndexService service;
//
//    @Override
//    public IService<GemfireIndex> getService() {
//        return service;
//    }

}
