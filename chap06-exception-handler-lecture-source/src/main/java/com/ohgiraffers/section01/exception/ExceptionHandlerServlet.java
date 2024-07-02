package com.ohgiraffers.section01.exception;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/showerrorpage")
public class ExceptionHandlerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // getAttributeNames : request 객체가 가지고 있는 속성의 이름을 모두 가져온다.
        Enumeration<String> attrName = request.getAttributeNames();
        while (attrName.hasMoreElements()) {
            System.out.println(attrName.nextElement());
        }

        String forwardRequestUri = (String) request.getAttribute("servlet.forward.request_uri");
        String contextPath = (String) request.getAttribute("servlet.forward.context_path");
        String servletPath = (String) request.getAttribute("servlet.forward.servlet_path");
        HttpServletMapping mapping = request.getHttpServletMapping();
        Integer statusCode = (Integer) request.getAttribute("servlet.error.message");
        String message = (String) request.getAttribute("servlet.error.servlet_name");
        String servletName = (String) request.getAttribute("servlet.error.request_uri");
        String requestURI = (String) request.getAttribute("servlet.error.status_code");
    }
}
