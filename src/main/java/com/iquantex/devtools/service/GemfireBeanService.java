package com.iquantex.devtools.service;

import com.iquantex.devtools.base.server.BaseService;
import com.iquantex.devtools.bean.GemfireBeans;
import com.iquantex.devtools.model.GemfireBean;
import com.iquantex.devtools.model.GemfireField;
import com.iquantex.devtools.model.GemfireIndex;

import java.util.List;

/**
 * Created by hutx on 21:35 2018/11/21
 */
public interface GemfireBeanService extends BaseService<GemfireBean> {

    GemfireBeans findBeanFieldInfoByClassId(int classId) throws Exception;

    void saveBeanFieldInfo(Integer classId, List<GemfireField> fieldList, List<GemfireIndex> indexList) throws Exception;
}
