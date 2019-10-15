package cn.jsfund.devtools.sys.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.sys.service.ISysOperationLogService;
import cn.jsfund.devtools.sys.entity.SysOperationLog;
/**
 * <p>
 * 操作日志 前端控制器
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
@RestController
@RequestMapping("/api/sys/sys-operation-log")
public class SysOperationLogController extends BaseWebController<ISysOperationLogService, SysOperationLog> {

}
