import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/RequestParamsServlet")
public class RequestParamsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        String operator = request.getParameter("operator");
        try {
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);
            request.setAttribute("num1", n1);
            request.setAttribute("num2", n2);
            request.setAttribute("operator", operator);
        } catch (NumberFormatException e) {
            request.setAttribute("result", "输入必须为数字");
            RequestDispatcher resultServlet = request.getRequestDispatcher("servlet3");
            resultServlet.forward(request,response);
        } finally {
            RequestDispatcher operatorServlet = request.getRequestDispatcher("servlet2");
            operatorServlet.forward(request,response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
