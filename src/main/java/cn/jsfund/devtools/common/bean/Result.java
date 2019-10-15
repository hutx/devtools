package cn.jsfund.devtools.common.bean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by hutx on 17:04 2018/11/21
 */
public class Result {

    // ----------------------------------------异常码(http状态码)--------------------------------------------------
    // 正常返回
    public static final int SUCCESS = 200;

    // 数据没有发生变化(一般用于更新操作时，没有发生变化)
    public static final int NOT_MODIFIED = 304;

    // 客户端它发送了一个错误的请求(一般是参数不合法，可以在校验异常中使用)
    public static final int BAD_REQUEST = 400;

    // 没有认证(一般是没有登录)
    public static final int UNAUTHORIZED = 401;

    // 请求被服务器拒绝了(一般是认证通过了,但是没有权限访问该资源)
    public static final int FORBIDDEN = 403;

    // 服务器无法找到所请求的URL(一般在Controller中使用)
    public static final int NOT_FOUND = 404;

    // 发起的请求中带有所请求的URL不支持的方法时(如果该方法仅支持POST请求，用GET请求则报错)
    public static final int METHOD_NOT_ALLOWED = 405;

    // 请求超时(客户端完成请求所花的时间太长)
    public static final int REQUEST_TIMEOUT = 408;

    // 服务器异常(一般数处理逻辑出现异常,可以在service中使用)
    public static final int ERROR = 500;

    // ----------------------------------------返回信息-------------------------------------

    // 返回状态信息,默认200
    private int code = 200;

    // 返回的数据
    private Object data = null;

    private Pagination pagination;

    // 返回的信息
    private String msg = "";

    // 异常堆栈
    private String msgDetail = "";

    //标识请求的线程id
    private String requestId = "";

    public Result() {
        this(SUCCESS, null, null, null, null);
    }

    public Result(Object date) {
        this(SUCCESS, date, null, null, null);
    }

    public Result(int code, Object date, Pagination pagination, String msg, String msgDetail) {
        this.code = code;
        this.data = date;
        this.msg = msg;
        this.msgDetail = msgDetail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public String getMsgDetail() {
        return msgDetail;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    /**
     * 处理异常信息
     *
     * @param e
     * @return
     */
    public static String getStackMsg(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        return sw.toString();
    }

    /**
     * 获取异常详情（包含请求url）
     *
     * @return
     */
    private static String getDetailMsg(Exception e) {
        return getStackMsg(e);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setMsgDetail(String msgDetail) {
        this.msgDetail = msgDetail;
    }

    /**
     * 将数据添加到data
     *
     * @param key
     * @param value
     * @return
     */
    public Result setData(String key, Object value) {
        // 如果data不是JSONObject对象，则将data转化为JSONObject对象
        if (data == null) {
            data = new JSONObject();
        }
        if (!(this.data instanceof JSONObject)) {
            this.data = JSONObject.parseObject(JSON.toJSONString(this.data));
        }
        ((JSONObject) this.data).put(key, value);
        return this;
    }
}
