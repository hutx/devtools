package cn.jsfund.devtools.service.impl;

import cn.jsfund.devtools.base.server.impl.BaseServiceImpl;
import cn.jsfund.devtools.bean.GemfireBeans;
import cn.jsfund.devtools.mapper.dao.java.GemfireBeanMapper;
import cn.jsfund.devtools.mapper.dao.java.GemfireFieldMapper;
import cn.jsfund.devtools.mapper.dao.java.GemfireIndexMapper;
import cn.jsfund.devtools.model.GemfireBean;
import cn.jsfund.devtools.model.GemfireField;
import cn.jsfund.devtools.model.GemfireIndex;
import cn.jsfund.devtools.service.GemfireBeanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Created by hutx on 21:35 2018/11/21
 */
@Service
public class GemfireBeanServiceImpl extends BaseServiceImpl<GemfireBean> implements GemfireBeanService {

    private static final Logger logger = LoggerFactory.getLogger(GemfireBeanServiceImpl.class);

    @Autowired
    private GemfireBeanMapper gemfireBeanMapper;

    @Autowired
    private GemfireFieldMapper fieldMapper;

    @Autowired
    private GemfireIndexMapper indexMapper;

    public Mapper<GemfireBean> getMapper() {
        return gemfireBeanMapper;
    }

    @Override
    public GemfireBeans findBeanFieldInfoByClassId(int classId) throws Exception {
        GemfireBeans beans = new GemfireBeans();
        beans.setClassId(classId);
        GemfireField field = new GemfireField();
        field.setClassId(classId);
        beans.setFieldList(fieldMapper.select(field));
        GemfireIndex index = new GemfireIndex();
        index.setClassId(classId);
        beans.setIndexList(indexMapper.select(index));
        return beans;
    }

    @Transactional
    @Override
    public void saveBeanFieldInfo(Integer classId, List<GemfireField> fieldList, List<GemfireIndex> indexList) {
        //1. 先删除该Bean 的字段和索引配置信息，以新数据添加
        GemfireField field = new GemfireField();
        field.setClassId(classId);
        fieldMapper.delete(field);
        GemfireIndex index = new GemfireIndex();
        index.setClassId(classId);
        indexMapper.delete(index);
        fieldList.forEach(item -> fieldMapper.insertSelective(item));
        indexList.forEach(item -> indexMapper.insertSelective(item));
    }
}
