import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.io.*;
import java.util.Properties;

public class CounterListener implements ServletContextListener {
    ServletContext servletContext;
    Properties properties;
    Counter counter;
    @Override
    public void contextInitialized(ServletContextEvent httpSessionEvent){
        try {
            servletContext = httpSessionEvent.getServletContext();
            System.out.println(servletContext.getRealPath("/WEB-INF/classes/count.properties"));

            InputStream is =servletContext.getResourceAsStream("/WEB-INF/classes/count.properties");
            properties = new Properties();
            properties.load(is);
            counter=new Counter(Integer.parseInt(properties.getProperty("count")));
            System.out.println("Counter已初始化:count="+counter.getCount());
            servletContext.setAttribute("counter",counter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent){
        try {
            properties.setProperty("count",String.valueOf(counter.getCount()));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(servletContext.getRealPath("/WEB-INF/classes/count.properties")));
            properties.store(bufferedOutputStream, "Update");
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("count已保存:count="+properties.getProperty("count"));
    }
}