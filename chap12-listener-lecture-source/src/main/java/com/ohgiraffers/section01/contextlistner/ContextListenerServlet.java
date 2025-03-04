package com.ohgiraffers.section01.contextlistner;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/context")

public class ContextListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("context listener 확인용 서블릿");

        ServletContext context = request.getServletContext();

        // context에 attribute를 추가하게 되면 attributedAdded() 메소드가 동작한다.
        context.setAttribute("test","value");

        // 동일한 key로 context에 attribute를 추가하면(수정하면)
        // attirbuteReplaced() 메소드가 동작한다.
        context.setAttribute("test","value2");

        // 동일한 key로 context에 attribute를 제거하면 attirbuteReplaced() 메소드가 동작한다.
        context.removeAttribute("test");

    }


}
