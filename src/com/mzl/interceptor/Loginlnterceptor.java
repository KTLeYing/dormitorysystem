package com.mzl.interceptor;

import com.mzl.po.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 */
public class Loginlnterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 获取请求的URL
        String url = httpServletRequest.getRequestURI();
        // URL:除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
        if (url.indexOf("/login") >= 0){
            return true;
        }
        //获取Session
        HttpSession session = httpServletRequest.getSession();
        Admin admin = (Admin) session.getAttribute("admin");
        // 判断Session中是否有用户数据，如果有，则返回true,继续向下执行
        if (admin != null){
            return true;
        }

        // 不符合条件的给出提示信息，并转发到主页面
        httpServletRequest.setAttribute("msga", "您还没有登录，请先登录！");
        httpServletRequest.getRequestDispatcher("/shopping homepage.jsp").forward(httpServletRequest, httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
