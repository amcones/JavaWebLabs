import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/OperatorServlet")
public class OperatorServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double num1= (double) request.getAttribute("num1");
        double num2= (double) request.getAttribute("num2");
        String operator = (String) request.getAttribute("operator");
        Object result = 0;
        switch (operator){
            case "+":
                result=num1+num2;
                break;
            case "-":
                result=num1-num2;
                break;
            case "*":
                result=num1*num2;
                break;
            case "/":
                result=num2==0?"除数不能为0":num1/num2;
        }
        request.setAttribute("result",result);
        RequestDispatcher resultServlet = request.getRequestDispatcher("servlet3");
        resultServlet.forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
