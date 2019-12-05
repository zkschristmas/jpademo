package cn.yoursky.jpademo.handler;

import java.util.List;

public final class ApiResultGenerator {
    /**
     * 创建普通消息方法
     * @param flag 执行接口状态，true:执行成功，false：执行失败
     * @param msg 返回消息内容
     * @param result 返回结果
     * @param jumpUrl 跳转路径
     */
    public static ApiResult result (boolean flag , String msg , Object result , String jumpUrl , int rows , Throwable throwable) {
        ApiResult apiResult = ApiResult.newInstance();
        apiResult.setFlag(flag);
        apiResult.setMsg(msg.equals("")  ? "执行成功":msg);
        apiResult.setResult(result);
        apiResult.setJumpUrl(jumpUrl);
        apiResult.setRows(rows);
        apiResult.setTime(System.currentTimeMillis());
        return apiResult;
    }

    /**
     * 返回执行成功试图方法
     *
     */
    public static ApiResult successResult(Object result) {
        int rows = 0;
        if (result instanceof List) {
            rows = ((List)result).size();
        }
        return result(true,"",result,"",rows, null);
    }
    /**
     * 执行失败后返回试图方法
     */
    public static ApiResult errorResult(String msg , Throwable throwable) {
        return result(false,msg,"","",0, null);
    }
}
