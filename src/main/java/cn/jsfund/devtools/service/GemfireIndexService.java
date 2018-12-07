package cn.jsfund.devtools.service;

import cn.jsfund.devtools.base.server.BaseService;
import cn.jsfund.devtools.model.GemfireIndex;

import java.util.List;

/**
 * Created by hutx on 15:20 2018/11/22
 */
public interface GemfireIndexService extends BaseService<GemfireIndex> {

    List<GemfireIndex> findTableIndex(int baseId, String tableName) throws Exception;
}