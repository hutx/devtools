package cn.jsfund.devtools.controller;


import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.entity.GemfireBean;
import cn.jsfund.devtools.service.IGemfireBeanService;
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
@RequestMapping("/api/gemfires")
public class GemfireBeanController extends BaseWebController<IGemfireBeanService,GemfireBean> {

//    @Autowired
//    private IGemfireBeanService service;
//
//    @Override
//    public IService<GemfireBean> getService() {
//        return service;
//    }

}
