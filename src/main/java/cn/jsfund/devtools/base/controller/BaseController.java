package cn.jsfund.devtools.base.controller;

import com.baomidou.mybatisplus.extension.service.IService;


/**
 * Created by hutx on 17:04 2018/11/21
 */
public interface BaseController<T> {

    IService<T> getIService();
}
