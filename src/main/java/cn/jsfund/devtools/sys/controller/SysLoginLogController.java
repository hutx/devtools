package cn.jsfund.devtools.sys.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.sys.service.ISysLoginLogService;
import cn.jsfund.devtools.sys.entity.SysLoginLog;
/**
 * <p>
 * 登录记录 前端控制器
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
@RestController
@RequestMapping("/api/sys/sys-login-log")
public class SysLoginLogController extends BaseWebController<ISysLoginLogService, SysLoginLog> {

}
