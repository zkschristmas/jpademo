package cn.yoursky.jpademo.handler;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiResult implements Serializable {
    //消息提示
    private String msg;
    //状态信息
    private boolean flag = true;
    //返回结构
    private Object result;
    //查询出的结构总数
    private int rows;
    //需要跳转的路径
    private String jumpUrl;
    //接口相应时间毫秒单位；
    private long time;

    private ApiResult() {}

    public static ApiResult newInstance() {
        return new ApiResult();
    }
}
