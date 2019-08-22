package cn.zyuanyuan.common;

import cn.zyuanyuan.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * http请求前后监听工具
 * Created by Administrator on 2019/6/4.
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    private static final String START_TIME = "requestStartTime";
    @Override
    /*请求之前*/
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI().toString();
        Map parameterMap = request.getParameterMap();  /*传参，注意敏感信息过滤*/
        log.info("request start. url:{},params:{}",url, JsonMapper.obj2String((parameterMap)));
        Long start = System.currentTimeMillis();
        request.setAttribute(START_TIME,start);
        return true;
    }

    @Override
    /*请求正常结束后*/
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
 /*       String url = request.getRequestURI().toString();
        Long start = (Long) request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        log.info("request finished. url:{},cost:{}",url, end-start);*/
        removeThreadLocalInfo();
    }

    @Override
    /*请求正常异常后*/
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURI().toString();
        Long start = (Long) request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        log.info("request completed. url:{},cost:{}",url, end-start);

        removeThreadLocalInfo();
    }


    public void removeThreadLocalInfo() {
        RequestHolder.remove();;
    }
}
