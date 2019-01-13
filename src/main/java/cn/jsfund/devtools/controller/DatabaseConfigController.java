package cn.jsfund.devtools.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.service.IDatabaseConfigService;
import cn.jsfund.devtools.entity.DatabaseConfig;
/**
 * <p>
 * 数据库配置 前端控制器
 * </p>
 *
 * @author hutx
 * @since 2019-01-13
 */
@RestController
@RequestMapping("/api/database-config")
public class DatabaseConfigController extends BaseWebController<IDatabaseConfigService, DatabaseConfig> {

}
