package com.ohgiraffers.section01.cookie;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/redirect")

public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        System.out.println("(redirect) firstName: " + firstName);
        System.out.println("(redirect) lastName: " + lastName);

        /*
        * 쿠키 사용하기
        * 1. request에서 쿠키 목록을 쿠키 배열 형태로 꺼내온다.
        * 2. 쿠키의 getName과 getValue를 이용해 쿠키에 담긴 값을 사용한다.
         */

        Cookie[] cookies = request.getCookies();
        for(int i = 0; i < cookies.length; i++){
            System.out.println("[cookie]" + cookies[i].getName() +
                    " : " + cookies[i].getValue());
            if("firstName".equals(cookies[i].getName())){
                firstName = cookies[i].getValue();
            } else if ("lastName".equals(cookies[i].getName())) {
                lastName = cookies[i].getValue();
            }

        }

    }
}
