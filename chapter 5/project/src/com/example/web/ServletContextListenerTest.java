package com.example.web;

import com.example.models.Dog;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Dmitrii on 11.09.2018.
 */
public class ServletContextListenerTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        ServletContext context = getServletContext();
        Dog dog = (Dog) context.getAttribute("dog");
        HttpSession session = request.getSession();
        session.setAttribute("dog", dog);

        writer.println("<h1>Servlet context parameter dog</h1>");
        writer.println("<h2>Dog's breed is: " + dog.getBreed() + "</h2>");
    }
}
