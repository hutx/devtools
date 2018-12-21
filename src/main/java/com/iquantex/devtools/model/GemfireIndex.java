package com.iquantex.devtools.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "gemfire_index")
public class GemfireIndex {
    @ColumnType(jdbcType = JdbcType.INTEGER)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "class_id")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer classId;

    @Column(name = "field_code")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fieldCode;

    public static final String TABLE = "gemfire_index";

    public static final String f_id = "id";

    public static final String f_classId = "classId";

    public static final String f_fieldCode = "fieldCode";

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
     * @return field_code
     */
    public String getFieldCode() {
        return fieldCode;
    }

    /**
     * @param fieldCode
     */
    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode == null ? null : fieldCode.trim();
    }
}