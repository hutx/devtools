package cn.jsfund.devtools.base.controller;

import cn.jsfund.devtools.bean.Result;
import cn.jsfund.devtools.exception.SystemException;
import cn.jsfund.devtools.base.server.BaseService;
import com.github.pagehelper.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hutx on 17:13 2018/11/21
 */
public abstract class BaseWebController<T> extends BaseController {

    public BaseWebController() {
    }

    @GetMapping({"/query"})
    public Result query(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "20") int pageSize, @RequestParam(required = false) T entity) {
        try {
            BaseService service = this.getRealService();
            Page<T> page = new Page<>(pageNum, pageSize);
            return this.successReturn(service.queryByPage(page, entity));
        } catch (Exception var4) {
            this.handleExeception(var4);
            return this.successReturn();
        }
    }


    @GetMapping({"/list"})
    public Result list(@RequestParam(required = false) T entity) {
        try {
            BaseService service = this.getRealService();
            return this.successReturn().setData("list", service.list(entity));
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
    public Result delete(@RequestBody T entity) {
        try {
            BaseService service = this.getRealService();
            service.delete(entity);
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
