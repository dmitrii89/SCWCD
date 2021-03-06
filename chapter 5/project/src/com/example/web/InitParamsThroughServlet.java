package com.example.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InitParamsThroughServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userMail = getServletConfig().getInitParameter("otherMail");
        req.setAttribute("otherMail", userMail);

        RequestDispatcher view = req.getRequestDispatcher("paramsTemplate.jsp");
        view.forward(req, resp);
    }
}
