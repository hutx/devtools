package cn.jsfund.devtools.base.controller;

import cn.jsfund.devtools.common.bean.Pagination;
import cn.jsfund.devtools.common.bean.Result;
import cn.jsfund.devtools.exception.SystemException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by hutx on 17:13 2018/11/21
 */
@SuppressWarnings("unchecked")
public class BaseWebController<M extends IService<T>, T> implements BaseController<T> {

    @Autowired
    private M iService;

    public BaseWebController() {
    }

    @Override
    public M getIService() {
        return this.iService;
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
            T entity = null;
            if (!StringUtils.isEmpty(query)) {
                entity = (T) JSON.parseObject(query);
            }
            IPage<T> page = this.iService.page(new Page<>(currentPage, pageSize), new QueryWrapper<>(entity));
            return this.successReturn(page.getRecords(), this.getPagination(page.getCurrent(), page.getSize(), page.getTotal()));
        } catch (Exception var4) {
            this.handleExeception(var4);
            return this.successReturn();
        }
    }


    @GetMapping({"/list"})
    public Result list(@RequestParam(required = false) T entity) {
        try {
            return this.successReturn(this.iService.list(new QueryWrapper<>(entity)));
        } catch (Exception var4) {
            this.handleExeception(var4);
            return this.successReturn();
        }
    }

    @PostMapping
    public Result add(@RequestBody T entity) {
        try {
            this.iService.saveOrUpdate(entity);
            return this.successReturn();
        } catch (Exception var4) {
            this.handleExeception(var4);
            return this.successReturn();
        }
    }

    @PostMapping("/batchAdd")
    public Result add(@RequestBody List<T> entity) {
        try {
            this.iService.saveOrUpdateBatch(entity);
            return this.successReturn();
        } catch (Exception var4) {
            this.handleExeception(var4);
            return this.successReturn();
        }
    }

    @PutMapping
    public Result update(@RequestBody T entity) {
        try {
            this.iService.updateById(entity);
            return this.successReturn();
        } catch (Exception var4) {
            this.handleExeception(var4);
            return this.successReturn();
        }
    }

    @DeleteMapping
    public Result bacthDelete(@RequestBody List<T> entitys) {
        try {
            this.iService.removeByIds((Collection<? extends Serializable>) entitys);
            return this.successReturn();
        } catch (Exception var4) {
            this.handleExeception(var4);
            return this.successReturn();
        }
    }

//    private IService<T> getBaseervice() throws SystemException {
//        IService<T> service = this.getService();
//        if (null == service) {
//            throw new SystemException("未定义service");
//        } else {
//            return service;
//        }
//    }
//
//    protected String getBasePath(HttpServletRequest request) {
//        return request.getServletContext().getRealPath("/");
//    }
//
//    protected IService<T> getService() {
//        return null;
//    }


    private void handleExeception(Exception e) {
        if (e instanceof SystemException) {
            throw (SystemException) e;
        } else {
            throw new SystemException("数据查询失败: " + e.getMessage(), e);
        }
    }

    /**
     * 返回成功
     *
     * @return
     */
    private Result successReturn() {
        return successReturn(null);
    }

    /**
     * 返回成功
     *
     * @param data 返回的数据
     * @return
     */
    public Result successReturn(Object data, Pagination pagination) {
        return successReturn(data, "", pagination);
    }

    public Result successReturn(Object data) {
        return successReturn(data, "", null);
    }

    public Pagination getPagination(long current, long pageSize, long total) {
        return new Pagination(current, pageSize, total);
    }

    /**
     * 返回成功
     *
     * @param data 返回的数据
     * @param msg  返回的信息
     * @return
     */
    public Result successReturn(Object data, String msg, Pagination pagination) {
        // 如果对象为空，则默认初始化为Json对象
        if (null == data) {
            data = new JSONObject();
        }
        Result Result = new Result(200, data, msg, "", pagination);
        return Result;
    }

    /**
     * 返回失败
     *
     * @param msg 返回的信息
     * @return
     */
    public Result errorReturn(int code, String msg) {
        return errorReturn(code, msg, "");
    }

    /**
     * 返回失败
     *
     * @param msg      返回的信息
     * @param msgDebug 返回的错误堆栈信息
     * @return
     */
    public Result errorReturn(int code, String msg, Exception msgDebug) {
        return new Result(code, new JSONObject(), msg, msgDebug);
    }

    /**
     * 返回失败
     *
     * @param msg      返回的信息
     * @param msgDebug 返回的错误堆栈信息
     * @return
     */
    public Result errorReturn(int code, String msg, String msgDebug) {
        return new Result(code, new JSONObject(), msg, msgDebug);
    }
}
