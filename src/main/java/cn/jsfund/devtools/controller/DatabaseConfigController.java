package cn.jsfund.devtools.controller;


import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.entity.DatabaseConfig;
import cn.jsfund.devtools.service.IDatabaseConfigService;
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
@RequestMapping("/api/database-config")
public class DatabaseConfigController extends BaseWebController<IDatabaseConfigService,DatabaseConfig> {

//    @Autowired
//    private IDatabaseConfigService service;
//
//    @Override
//    public IService<DatabaseConfig> getService() {
//        return service;
//    }

}
