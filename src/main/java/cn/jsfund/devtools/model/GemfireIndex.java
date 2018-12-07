package cn.jsfund.devtools.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "gemfire_index")
public class GemfireIndex {
    @Id
    @ColumnType(jdbcType = JdbcType.INTEGER)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "gemfire_id")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private Integer gemfireId;

    @Column(name = "field_code")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String fieldCode;

    public static final String TABLE = "gemfire_index";

    public static final String f_id = "id";

    public static final String f_gemfireId = "gemfireId";

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
     * @return gemfire_id
     */
    public Integer getGemfireId() {
        return gemfireId;
    }

    /**
     * @param gemfireId
     */
    public void setGemfireId(Integer gemfireId) {
        this.gemfireId = gemfireId;
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