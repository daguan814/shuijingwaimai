package org.shuijing.shuijingwaimai.filter;

/**
 * @ClassName: LoginCheckFilter
 * @Description: TODO
 * @author: 达观
 * @date: 2022/7/24  14:05
 */

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.shuijing.shuijingwaimai.common.Result;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.sql.Struct;

/**
 * 检查用户是否登录
 */


@WebFilter(filterName = "LoginCheckFilter", urlPatterns = "/*")
@Slf4j
@Component
public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();//路径匹配器
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取本此请求的uri
        String requestURI = request.getRequestURI();


        String[] urls = new String[]{ //不需要处理的请求
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                //下面是关闭这个登陆的过滤器
                "/employee",
                "/employee/**"
        };

        //判断本次请求是否需要处理
        boolean check = check(urls,requestURI);

        if (check){
            filterChain.doFilter(request,response);
            return;
        }



        //判断用户是否登录
        if(request.getSession().getAttribute("employee") != null){
            filterChain.doFilter(request,response);
            return;
        }

        //没有登录返回未登陆的结果，通过输出流向客户端页面响应数据
        response.getWriter().write(JSON.toJSONString(Result.error("NOTLOGIN")));
        return;
    }

    /**
     * 路径匹配
     * @param urls
     * @param requestURI
     * @return
     */

    public boolean check(String[] urls,String requestURI){

        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url,requestURI);  //比较两个路径
            if (match) {
                return true;
            }
        }
        return false;
    }

}
