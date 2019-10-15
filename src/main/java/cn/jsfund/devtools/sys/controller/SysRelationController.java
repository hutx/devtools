package cn.jsfund.devtools.sys.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import cn.jsfund.devtools.base.controller.BaseWebController;
import cn.jsfund.devtools.sys.service.ISysRelationService;
import cn.jsfund.devtools.sys.entity.SysRelation;
/**
 * <p>
 * 角色和菜单关联表 前端控制器
 * </p>
 *
 * @author hutx
 * @since 2019-01-21
 */
@RestController
@RequestMapping("/api/sys/sys-relation")
public class SysRelationController extends BaseWebController<ISysRelationService, SysRelation> {

}
