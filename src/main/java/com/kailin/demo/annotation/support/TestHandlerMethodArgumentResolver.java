package com.kailin.demo.annotation.support;

import com.kailin.demo.annotation.UserId;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static Logger logger = LoggerFactory.getLogger(TestHandlerMethodArgumentResolver.class);

    /**
     * 拦截器自带缓存机制，在第一次拦截到某个请求携带的参数时，supportsParameter会被执行，拦截器会缓存supportsParameter执行后的返回值。
     * 下一次再拦截到同个请求URL的同个参数时，拦截器不会再执行supportsParameter会被执行，而是直接读取上次缓存的返回值，若为true，就继续
     * 执行resolveArgument，若为false，就不执行resolveArgument
     * @param parameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        String controllerName = parameter.getDeclaringClass().getSimpleName();
        RequestMapping requestMapping = parameter.getDeclaringClass().getAnnotation(RequestMapping.class);
        String controllerUrl = requestMapping.value()[0];
        String url = null;
        String method = null;
        GetMapping getMapping = parameter.getMethodAnnotation(GetMapping.class);
        if(getMapping != null){
            url = controllerUrl + "/" + getMapping.value()[0];
            method = "Get";
        }else{
            PostMapping postMapping = parameter.getMethodAnnotation(PostMapping.class);
            url = controllerUrl + "/" + postMapping.value()[0];
            method = "Post";
        }

        logger.debug("{}, Url={}, 参数名称：{}，请求方式={}",controllerName,url,parameter.getParameterName(),method);

        return parameter.hasParameterAnnotation(UserId.class) &&
                parameter.getParameterType().isAssignableFrom(String.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        String id = nativeWebRequest.getParameter("id");
        id = id + ".com";
        logger.debug("id = "+id);
        return id;
    }
}
