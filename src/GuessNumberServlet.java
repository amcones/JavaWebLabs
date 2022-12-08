import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "GuessNumberServlet", value = "/GuessNumberServlet")




public class GuessNumberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Guess guess;

    public GuessNumberServlet() {
        guess = new Guess();
    }
    public static boolean judge(String num){
        try {
            Integer.valueOf(num);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(guess.getRandNum());
        String num = request.getParameter("num");
        if (!judge(num)) {
            response.sendRedirect("/index.jsp");
        } else {
            int number = Integer.parseInt(num);
            if (number < 1 || number > 99) {
                response.sendRedirect("/index.jsp");
            }
            else {
                int flag=guess.judge(number);
                if (flag==0){
                    HttpSession session = request.getSession();
                    session.setAttribute("count", guess.getCount());
                    guess=new Guess();
                    response.sendRedirect("servlet2");
                }
                else {
                    if(flag==-1){
                        request.setAttribute("ans","猜小了");
                    }
                    else {
                        request.setAttribute("ans","猜大了");
                    }
                    RequestDispatcher view=request.getRequestDispatcher("/index.jsp");
                    view.forward(request,response);

                }
            }

        }



    }

        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
                ServletException, IOException {
            this.doGet(request, response);
        }
}
