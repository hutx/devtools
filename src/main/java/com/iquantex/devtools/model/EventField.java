package com.iquantex.devtools.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "event_field")
public class EventField {
    @ColumnType(jdbcType = JdbcType.INTEGER)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "class_id")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer classId;

    /**
     * 字段CODE
     */
    @Column(name = "field_code")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fieldCode;

    /**
     * 字段名称
     */
    @Column(name = "field_name")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fieldName;

    /**
     * 字段类型
     */
    @Column(name = "field_type")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fieldType;

    /**
     * 是否主键<>Y=1=是&N=0=否
     */
    @Column(name = "is_key")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer isKey;

    /**
     * 是否主键<>Y=1=是&N=0=否
     */
    @Column(name = "is_null")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer isNull;

    @Column(name = "min_value")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer minValue;

    @Column(name = "max_vale")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer maxVale;

    /**
     * 描述
     */
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String comment;

    public static final String TABLE = "event_field";

    public static final String f_id = "id";

    public static final String f_classId = "classId";

    public static final String f_fieldCode = "fieldCode";

    public static final String f_fieldName = "fieldName";

    public static final String f_fieldType = "fieldType";

    public static final String f_isKey = "isKey";

    public static final String f_isNull = "isNull";

    public static final String f_minValue = "minValue";

    public static final String f_maxVale = "maxVale";

    public static final String f_comment = "comment";

    /**
     * 是
     */
    public static final Integer c_isKey_Y = 1;

    /**
     * 否
     */
    public static final Integer c_isKey_N = 0;

    /**
     * 是
     */
    public static final Integer c_isNull_Y = 1;

    /**
     * 否
     */
    public static final Integer c_isNull_N = 0;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return class_id
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * @param classId
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * 获取字段CODE
     *
     * @return field_code - 字段CODE
     */
    public String getFieldCode() {
        return fieldCode;
    }

    /**
     * 设置字段CODE
     *
     * @param fieldCode 字段CODE
     */
    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode == null ? null : fieldCode.trim();
    }

    /**
     * 获取字段名称
     *
     * @return field_name - 字段名称
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 设置字段名称
     *
     * @param fieldName 字段名称
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    /**
     * 获取字段类型
     *
     * @return field_type - 字段类型
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * 设置字段类型
     *
     * @param fieldType 字段类型
     */
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType == null ? null : fieldType.trim();
    }

    /**
     * 获取是否主键<>Y=1=是&N=0=否
     *
     * @return is_key - 是否主键<>Y=1=是&N=0=否
     */
    public Integer getIsKey() {
        return isKey;
    }

    /**
     * 设置是否主键<>Y=1=是&N=0=否
     *
     * @param isKey 是否主键<>Y=1=是&N=0=否
     */
    public void setIsKey(Integer isKey) {
        this.isKey = isKey;
    }

    /**
     * 获取是否主键<>Y=1=是&N=0=否
     *
     * @return is_null - 是否主键<>Y=1=是&N=0=否
     */
    public Integer getIsNull() {
        return isNull;
    }

    /**
     * 设置是否主键<>Y=1=是&N=0=否
     *
     * @param isNull 是否主键<>Y=1=是&N=0=否
     */
    public void setIsNull(Integer isNull) {
        this.isNull = isNull;
    }

    /**
     * @return min_value
     */
    public Integer getMinValue() {
        return minValue;
    }

    /**
     * @param minValue
     */
    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    /**
     * @return max_vale
     */
    public Integer getMaxVale() {
        return maxVale;
    }

    /**
     * @param maxVale
     */
    public void setMaxVale(Integer maxVale) {
        this.maxVale = maxVale;
    }

    /**
     * 获取描述
     *
     * @return comment - 描述
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置描述
     *
     * @param comment 描述
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }
}