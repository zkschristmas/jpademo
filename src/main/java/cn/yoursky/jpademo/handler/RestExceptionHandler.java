package cn.yoursky.jpademo.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {
    public ApiResult runtimeExceptionHandler (Exception e) {
        return ApiResultGenerator.errorResult(e.getMessage(),e);
    }
}
