package com.huyang.zhiqianquan.vo;

public class JsonResult {
    private String status;
    private String message;
    private Object data;
    /**
     * 用来规定输出的格式
     * @param status 返回状态
     * @param message	返回信息
     * @param data	返回值
     */
    public JsonResult(String status, String message, Object data) {
        this.status=status;
        this.message=message;
        this.data=data;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
