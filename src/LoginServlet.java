import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/GuessNumberServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config =this.getServletConfig();
        Enumeration<String> lists = config.getInitParameterNames();
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        while(lists.hasMoreElements()) {
            String username = lists.nextElement();
            String password = config.getInitParameter(username);
            if(request.getParameter("username").equals(username))
            {
                if(request.getParameter("password").equals(password)) {
                    request.setAttribute("result", "welcome "+username);
                    view.forward(request, response);
                }
                else{
                    request.setAttribute("result","Password is Incorrect!");
                    view.forward(request,response);
                }
                return;
            }
        }
        request.setAttribute("result","Username is not available!");
        view.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
