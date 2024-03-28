package org.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String timezone = request.getParameter("timezone");
        TimeZone tz = null;
        if(timezone != null && !timezone.isEmpty()){
            tz = TimeZone.getTimeZone(timezone);
        } else {
            tz = TimeZone.getTimeZone("UTC");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss zzz");
        sdf.setTimeZone(tz);

        String currentTime = sdf.format(new Date());

        out.println("<html><head><title>Current Time</title></head><body>");
        out.println("<h1>Current Time</h1>");
        out.println("<p>" + currentTime + "</p>");
        out.println("</body></html>");
    }
}
