package cn.jsfund.devtools.common.bean;


import cn.jsfund.devtools.entity.GemfireField;
import cn.jsfund.devtools.entity.GemfireIndex;

import java.util.List;

/**
 * Created by hutx on 13:53 2018/12/20
 */
public class GemfireBeans {
    private Integer classId;
    private List<GemfireField> fieldList;

    private List<GemfireIndex> indexList;

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public List<GemfireField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<GemfireField> fieldList) {
        this.fieldList = fieldList;
    }

    public List<GemfireIndex> getIndexList() {
        return indexList;
    }

    public void setIndexList(List<GemfireIndex> indexList) {
        this.indexList = indexList;
    }
}
