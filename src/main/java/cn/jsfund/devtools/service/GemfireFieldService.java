package cn.jsfund.devtools.service;

import cn.jsfund.devtools.base.server.BaseService;
import cn.jsfund.devtools.model.GemfireField;

import java.util.List;

/**
 * Created by hutx on 21:35 2018/11/21
 */
public interface GemfireFieldService extends BaseService<GemfireField> {

    /**
     *
     * @param baseId
     * @param tableName
     * @return
     */
    List<GemfireField> findTableField(int baseId , String tableName) throws Exception;
}
