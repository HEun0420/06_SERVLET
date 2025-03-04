package com.ohgiraffers.sesstion03.request;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/request")

public class RequestListenerTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // request에 attribute를 추가할 때 attirbuteAdded() 메소드가 동작한다.
        request.setAttribute("username","hongildong");
        request.setAttribute("age",20);
        request.setAttribute("gender","M");

        // request에 attributed를 동일한 key로 덮어 쓰는 경우
        // attributedReplaced 메소드가 동작한다.
        request.setAttribute("username", "hong");

        // request에 attribute를 제거할 때 attributeRemoved()가 동작한다.
        request.removeAttribute("gender");

    }
}
