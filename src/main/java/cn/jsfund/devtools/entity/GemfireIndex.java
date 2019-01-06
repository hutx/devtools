package cn.jsfund.devtools.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import cn.jsfund.devtools.base.BaseEntity;
/**
 * <p>
 * gemfire索引信息
 * </p>
 *
 * @author hutx
 * @since 2019-01-05
 */
public class GemfireIndex extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer gemfireId;

    private String fieldCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGemfireId() {
        return gemfireId;
    }

    public void setGemfireId(Integer gemfireId) {
        this.gemfireId = gemfireId;
    }

    public String getFieldCode() {
        return fieldCode;
    }

    public void setFieldCode(String fieldCode) {
        this.fieldCode = fieldCode;
    }

    public static final String ID = "id";

    public static final String GEMFIRE_ID = "gemfire_id";

    public static final String FIELD_CODE = "field_code";

    @Override
    public String toString() {
        return "GemfireIndex{" +
        ", id=" + id +
        ", gemfireId=" + gemfireId +
        ", fieldCode=" + fieldCode +
        "}";
    }
}
