package cn.jsfund.devtools.service;

import cn.jsfund.devtools.base.server.BaseService;
import cn.jsfund.devtools.bean.GemfireBeans;
import cn.jsfund.devtools.model.GemfireBean;
import cn.jsfund.devtools.model.GemfireField;
import cn.jsfund.devtools.model.GemfireIndex;

import java.util.List;

/**
 * Created by hutx on 21:35 2018/11/21
 */
public interface GemfireBeanService extends BaseService<GemfireBean> {

    GemfireBeans findBeanFieldInfoByClassId(int classId) throws Exception;

    void saveBeanFieldInfo(Integer classId, List<GemfireField> fieldList, List<GemfireIndex> indexList) throws Exception;
}
