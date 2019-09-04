package com.cxk.controller.Intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor{
    private String[] notPassPath = {"/teamlist", "/yourteam", "/createTeam", "/addTeam", "/logout"
                                      , "/info", "/modifyuserinfo", "/jointeam"};
    private String[] staticRes = {".jpg", ".png", ".css", ".js", ".html"};
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getServletPath();
        System.out.println("uri : " + uri);

        for (String path : notPassPath) {

            if (uri.contains(path)) {

                if (httpServletRequest.getSession().getAttribute("username") == null) {
                    System.out.println("intercept");
                    redirect(httpServletRequest, httpServletResponse);
                }
            }
        }
        return true;
    }

    public void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取当前请求的路径
        String basePath = request.getScheme() + "://" + request.getServerName() + ":"  + request.getServerPort()+request.getContextPath();
        //如果request.getHeader("X-Requested-With") 返回的是"XMLHttpRequest"说明就是ajax请求，需要特殊处理 否则直接重定向就可以了
        if("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))){
            //告诉ajax我是重定向
            response.setHeader("REDIRECT", "REDIRECT");
            //告诉ajax我重定向的路径
            response.setHeader("CONTENTPATH", "/CIMS/login");
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        }else{
            response.sendRedirect("/CIMS/login");
        }
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
