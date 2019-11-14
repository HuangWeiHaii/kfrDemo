package com.hwh.kfr.config;

import com.hwh.kfr.utils.CommonResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @ description 配置统一响应体
 * @ Date 2019年10月11日09:59:10
 * @ author hwh
 */
@ControllerAdvice
public class UnifiedResponseConfig implements ResponseBodyAdvice<Object>{
    @Override
    public boolean supports(MethodParameter methodParameter,
                            Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.hasMethodAnnotation(ResponseBody.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {

        if (body != null) {
            if (body instanceof String){
                return body;
            }
            return new CommonResult<Object>(body);
        }
        else {
            System.out.println("body is null");
            CommonResult<Object> commonResult = new CommonResult<Object>(null);
            commonResult.setStatus(-1);
            commonResult.setErrorCode("500");
            commonResult.setErrorMsg("error request");
            return commonResult;
        }
    }
}
