package com.ohgiraffers.section02.headers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

@WebServlet("/headers")

public class RessponseHeaderPrintServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        response.setHeader("Refresh", "1"); // 계속 새로고침

        // currenTimeMillis : 현재 시간을 밀리초로 반환해줌
        long currentTime = System.currentTimeMillis();

        out.println("<h1>" + currentTime + "</h1>");

        out.flush();
        out.close();

        Collection<String> responseHeaders = response.getHeaderNames();
        Iterator<String> iter = responseHeaders.iterator();

        // 응답헤더에 담기는 내용 확인하기
        while (iter.hasNext()) {
            String headerName = iter.next();
            System.out.println(headerName + ": " + response.getHeader(headerName));
        }

    }

}
