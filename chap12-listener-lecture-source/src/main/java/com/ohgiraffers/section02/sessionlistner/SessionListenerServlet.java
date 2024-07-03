package com.ohgiraffers.section02.sessionlistner;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/session")

public class SessionListenerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 세션 만들기
        HttpSession session = request.getSession();
        System.out.println("발급받은 session id : " + session.getId());

        // session이 만료하게 되면 sessionDestroyed가 동작한다.
        // session.setMaxUnactiveInterval(5);
//        session.invalidate(); // 바로 꺼짐


        // session에 attributed를 추가할 때 attributeAdded() 메소드가 동작한다.
        session.setAttribute("username","hoggildong");
        session.setAttribute("age","20");

        //  dto의 바인딩 리스너 확인
        session.setAttribute("user", new UserDTO("honggildong",20));

        // session attribute에 동일한 키로 덮어 쓰는 경우(수정) attributeReplaced 메소드가 동작한다.
        session.setAttribute("username","hong");

        // session attribute를 제거할 때 attributedRemoved()가 사용된다.
        session.removeAttribute("username");
    }


}
