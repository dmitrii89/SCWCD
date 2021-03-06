package com.example.web;

import com.example.nestedClasses.Dog;
import com.example.nestedClasses.Human;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NestedClassesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Human human = new Human();
        human.setName("Dima");
        Dog dog = new Dog();
        dog.setName("Fluffy");
        human.setDog(dog);

        Map<String, String> map = new HashMap<>();
        map.put("first", "First value");
        map.put("second", "Second value");

        request.setAttribute("human", human);
        request.setAttribute("map", map);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("NestedClassesTest.jsp");
        requestDispatcher.forward(request, response);
    }
}
