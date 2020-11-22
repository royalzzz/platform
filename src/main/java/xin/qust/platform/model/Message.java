package xin.qust.platform.model;

import com.alibaba.fastjson.JSONObject;
import xin.qust.platform.model.constant.ResponseCode;

public class Message {

    public Message() {

    }

    public Message(ResponseCode responseCode) {
        this.setResponseCode(responseCode);
    }
    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    private String token;
    /**
     * 响应具体数据
     */
    private Object data;

    /**
     * 响应额外信息
     */
    private Object extra;

    public static Message createSuccessMessage(Object data) {
        Message message = new Message(ResponseCode.SUCCESS);
        message.setData(data);

        return message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 设置响应信息
     *
     * @param responseCode 前端RESTful返回信息的响应码
     * @return 返回当前对象
     */
    public Message setResponseCode(ResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        return this;
    }

    public String toJsonString() {
        return JSONObject.toJSONString(this);
    }
}
