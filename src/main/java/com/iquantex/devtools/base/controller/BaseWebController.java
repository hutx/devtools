package com.iquantex.devtools.base.controller;

import com.iquantex.devtools.bean.Result;
import com.iquantex.devtools.exception.SystemException;
import com.iquantex.devtools.base.server.BaseService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hutx on 17:13 2018/11/21
 */
public abstract class BaseWebController<T> extends BaseController {

    public BaseWebController() {
    }

    /**
     * @param currentPage
     * @param pageSize
     * @param query       JSON 对像数据实体类 tomcat 8.5后 参数须 encodeURIComponent(JSON.stringify({className:"eee"}))
     * @return
     */
    @GetMapping({"/query"})
    public Result query(@RequestParam(required = false, defaultValue = "1") int currentPage, @RequestParam(required = false, defaultValue = "10") int pageSize, @RequestParam(required = false) String query) {
        try {
            BaseService service = this.getRealService();
            Page<T> page = new Page<>(currentPage, pageSize);
            T entity = null;
            if (!StringUtils.isEmpty(query)) {
                entity = (T) JSON.parseObject(query);
            }
            PageInfo pageInfo = service.queryByPage(page, entity);
            return this.successReturn(pageInfo.getList(), this.getPagination(pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getTotal()));
        } catch (Exception var4) {
            this.handleExeception(var4);
            return this.successReturn();
        }
    }


    @GetMapping({"/list"})
    public Result list(@RequestParam(required = false) T entity) {
        try {
            BaseService service = this.getRealService();
            return this.successReturn(service.list(entity));
        } catch (Exception var4) {
            this.handleExeception(var4);
            return this.successReturn();
        }
    }

    @PostMapping
    public Result add(@RequestBody T entity) {
        try {
            BaseService service = this.getRealService();
            service.insertSelective(entity);
            return this.successReturn();
        } catch (Exception var4) {
            this.handleExeception(var4);
            return this.successReturn();
        }
    }

    @PostMapping("/batchAdd")
    public Result add(@RequestBody List<T> entity) {
        try {
            BaseService service = this.getRealService();
            service.insertSelectiveBacth(entity);
            return this.successReturn();
        } catch (Exception var4) {
            this.handleExeception(var4);
            return this.successReturn();
        }
    }

    @PutMapping
    public Result update(@RequestBody T entity) {
        try {
            BaseService service = this.getRealService();
            service.updateByPrimaryKeySelective(entity);
            return this.successReturn();
        } catch (Exception var4) {
            this.handleExeception(var4);
            return this.successReturn();
        }
    }

    @DeleteMapping
    public Result bacthDelete(@RequestBody List<T> entitys) {
        try {
            BaseService service = this.getRealService();
            service.bacthDelete(entitys);
            return this.successReturn();
        } catch (Exception var4) {
            this.handleExeception(var4);
            return this.successReturn();
        }
    }


    private void handleExeception(Exception e) {
        if (e instanceof SystemException) {
            throw (SystemException) e;
        } else {
            throw new SystemException("数据查询失败: " + e.getMessage(), e);
        }
    }


    private BaseService getRealService() throws SystemException {
        BaseService<T> service = this.getService();
        if (null == service) {
            throw new SystemException("未定义service");
        } else {
            return service;
        }
    }

    protected String getBasePath(HttpServletRequest request) {
        return request.getServletContext().getRealPath("/");
    }

    protected BaseService<T> getService() {
        return null;
    }
}
