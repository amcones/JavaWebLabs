import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.Properties;

@WebServlet("/CounterServlet")

public class CounterServlet extends HttpServlet {
    ServletContext servletContext;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        servletContext=getServletContext();
        Counter counter = (Counter) servletContext.getAttribute("counter");
        counter.add();
        request.setAttribute("count",String.valueOf(counter.getCount()));
        RequestDispatcher imageServlet = request.getRequestDispatcher("image");
        imageServlet.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

