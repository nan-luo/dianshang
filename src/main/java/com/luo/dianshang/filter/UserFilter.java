package com.luo.dianshang.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 南磊
 * @date 2020/5/21 16:24
 * @Description
 */
public class UserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpServletResponse response= (HttpServletResponse) servletResponse;
        HttpSession session=request.getSession();
        if (session.getAttribute("user") == null){
            response.sendRedirect("/login");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
