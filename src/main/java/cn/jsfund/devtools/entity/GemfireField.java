package cn.jsfund.devtools.entity;
import cn.jsfund.devtools.base.BaseEntity;
/**
 * <p>
 * gemfire字段信息
 * </p>
 *
 * @author hutx
 * @since 2019-01-05
 */
public class GemfireField extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer classId;

    /**
     * 字段CODE
     */
    private String fieldCode;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 字段类型
     */
    private String fieldType;

    /**
     * 是否主键<>Y=1=是&N=0=否
     */
    private Integer isKey;

    /**
     * 是否主键<>Y=1=是&N=0=否
     */
    private Integer isNull;

    private String minValue;

    private String maxVale;

    /**
     * 描述
     */
    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public Integer getIsKey() {
        return isKey;
    }

    public void setIsKey(Integer isKey) {
        this.isKey = isKey;
    }

    public Integer getIsNull() {
        return isNull;
    }

    public void setIsNull(Integer isNull) {
        this.isNull = isNull;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public String getMaxVale() {
        return maxVale;
    }

    public void setMaxVale(String maxVale) {
        this.maxVale = maxVale;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static final String ID = "id";

    public static final String CLASS_ID = "class_id";

    public static final String FIELD_CODE = "field_code";

    public static final String FIELD_NAME = "field_name";

    public static final String FIELD_TYPE = "field_type";

    public static final String IS_KEY = "is_key";

    public static final String IS_NULL = "is_null";

    public static final String MIN_VALUE = "min_value";

    public static final String MAX_VALE = "max_vale";

    public static final String COMMENT = "comment";

    @Override
    public String toString() {
        return "GemfireField{" +
        ", id=" + id +
        ", classId=" + classId +
        ", fieldCode=" + fieldCode +
        ", fieldName=" + fieldName +
        ", fieldType=" + fieldType +
        ", isKey=" + isKey +
        ", isNull=" + isNull +
        ", minValue=" + minValue +
        ", maxVale=" + maxVale +
        ", comment=" + comment +
        "}";
    }
}
