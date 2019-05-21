package com.teiphu.Interceptor;

import com.teiphu.PermissionConstants;
import com.teiphu.annotation.RequiredPermission;
import com.teiphu.http.HttpStatus;
import com.teiphu.pojo.UserDo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author Teiphu
 * @Creation 2019.05.20 上午 01:47
 **/
public class SecurityInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LOGGER.info(request.getRequestURI());
        if (request.getRequestURI().startsWith("/bootstrap") || request.getRequestURI().startsWith("/common") ||
                request.getRequestURI().startsWith("/css") || request.getRequestURI().startsWith("/error") ||
                request.getRequestURI().startsWith("/img") || request.getRequestURI().startsWith("/js") ||
                request.getRequestURI().startsWith("/layer") || request.getRequestURI().startsWith("/layui") ||
                request.getRequestURI().startsWith("/layuiadmin") || request.getRequestURI().startsWith("/admin/home") ||
                request.getRequestURI().startsWith("/font")) {
            return true;
        }
        if (request.getRequestURI().startsWith("/reglog/")) {
            return true;
        }
        if (this.hasPermission(handler, request.getSession())) {
            return true;
        }
        response.sendError(HttpStatus.FORBIDDEN.getCode(), "没有权限");
        return false;
    }

    private boolean hasPermission(Object handler, HttpSession session) {
        UserDo user = (UserDo) session.getAttribute("user");
        if (user == null) {
            return false;
        }
        if (user.getRole().name().equals(PermissionConstants.ADMIN)) {
            return true;
        }
        if (handler instanceof HandlerMethod) {

            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RequiredPermission requiredPermission = handlerMethod.getMethod().getAnnotation(RequiredPermission.class);
            if (requiredPermission == null) {
                requiredPermission = handlerMethod.getMethod().getDeclaringClass().getAnnotation(RequiredPermission.class);
            }
            if (requiredPermission != null && StringUtils.isNotBlank(requiredPermission.value())) {
                return user.getRole().name().equals(requiredPermission.value());
            }

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
