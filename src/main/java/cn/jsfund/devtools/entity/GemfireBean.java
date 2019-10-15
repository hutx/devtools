package cn.jsfund.devtools.entity;
import cn.jsfund.devtools.base.BaseEntity;
/**
 * <p>
 * gemfire类信息
 * </p>
 *
 * @author hutx
 * @since 2019-01-05
 */
public class GemfireBean extends BaseEntity{

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String className;

    private String classCnName;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassCnName() {
        return classCnName;
    }

    public void setClassCnName(String classCnName) {
        this.classCnName = classCnName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public static final String ID = "id";

    public static final String CLASS_NAME = "class_name";

    public static final String CLASS_CN_NAME = "class_cn_name";

    public static final String REMARK = "remark";

    @Override
    public String toString() {
        return "GemfireBean{" +
        ", id=" + id +
        ", className=" + className +
        ", classCnName=" + classCnName +
        ", remark=" + remark +
        "}";
    }
}
