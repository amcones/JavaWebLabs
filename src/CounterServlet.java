import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

@WebServlet("/CounterServlet")
public class CounterServlet extends HttpServlet {
    ServletContext servletContext;
    Properties properties;
    public void init(){
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("count.properties"));
            properties = new Properties();
            properties.load(bufferedInputStream);
            servletContext = getServletContext();
            Counter counter=new Counter(Integer.parseInt(properties.getProperty("count")));
            System.out.println("Counter已初始化:count="+counter.getCount());
            servletContext.setAttribute("counter",counter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        Counter counter = (Counter) servletContext.getAttribute("counter");
        counter.add();
        properties.setProperty("count",String.valueOf(counter.getCount()));
        System.out.println("收到请求，count增加，count="+properties.getProperty("count"));
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    public void destroy(){
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("count.properties"));
            properties.store(bufferedOutputStream, "Update");
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("count已保存:count="+properties.getProperty("count"));
    }
}
