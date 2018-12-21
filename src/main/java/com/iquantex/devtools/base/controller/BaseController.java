package com.iquantex.devtools.base.controller;

import com.iquantex.devtools.bean.Pagination;
import com.iquantex.devtools.bean.Result;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by hutx on 17:04 2018/11/21
 */
public class BaseController {

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

    /**
     * 返回成功
     *
     * @return
     */
    protected Result successReturn() {
        return successReturn(null);
    }

    /**
     * 返回成功
     *
     * @param data 返回的数据
     * @return
     */
    protected Result successReturn(Object data, Pagination pagination) {
        return successReturn(data, "", pagination);
    }

    protected Result successReturn(Object data) {
        return successReturn(data, "", null);
    }

    protected Pagination getPagination(int current, int pageSize, long total) {
        return new Pagination(current, pageSize, total);
    }


    /**
     * 返回成功
     *
     * @param data 返回的数据
     * @param msg  返回的信息
     * @return
     */
    protected Result successReturn(Object data, String msg, Pagination pagination) {
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
    protected Result errorReturn(int code, String msg) {
        return errorReturn(code, msg, "");
    }

    /**
     * 返回失败
     *
     * @param msg      返回的信息
     * @param msgDebug 返回的错误堆栈信息
     * @return
     */
    protected Result errorReturn(int code, String msg, Exception msgDebug) {
        return new Result(code, new JSONObject(), msg, msgDebug);
    }

    /**
     * 返回失败
     *
     * @param msg      返回的信息
     * @param msgDebug 返回的错误堆栈信息
     * @return
     */
    protected Result errorReturn(int code, String msg, String msgDebug) {
        return new Result(code, new JSONObject(), msg, msgDebug);
    }
}
