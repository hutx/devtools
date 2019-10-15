package cn.jsfund.devtools.sys.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.sys.service.ISysDeptService;
import cn.jsfund.devtools.sys.entity.SysDept;
/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
@RestController
@RequestMapping("/api/sys/sys-dept")
public class SysDeptController extends BaseWebController<ISysDeptService, SysDept> {

}
