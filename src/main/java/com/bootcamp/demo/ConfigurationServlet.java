package com.bootcamp.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfigurationServlet extends HttpServlet {

        @Override
        public void init() throws ServletException {
            System.out.println("init() method invoked");
        }
        
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.execute(req, resp);
        }
        
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.execute(req, resp);
        }
        
        private void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
            String contextPath = request.getContextPath();
            String servletPath = request.getServletPath();
            String now = LocalDate.now().toString();
            String time = LocalTime.now().toString();
            String dateAndTime = LocalDateTime.now().toString();
            
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
            String formattedDate = dateTimeFormatter.format(LocalDate.now());
            
            String formattedTime = DateTimeFormatter.ofPattern("HH:mm").format(LocalTime.now());
            
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.print(String.format("<b>Context Path</b>: %s <br/>", contextPath));
            out.print(String.format("<b>Servlet Path</b>: %s <br/>", servletPath));
            out.print(String.format("<b>Current Date</b>: %s <br/>", now));
            out.print(String.format("<b>Current Time</b>: %s <br/>", time));
            out.print(String.format("<b>Current Date & Time</b>: %s <br/>", dateAndTime));
            out.print(String.format("<b>Formatted Date</b>: %s <br/>", formattedDate));
            out.print(String.format("<b>Formatted Time</b>: %s <br/>", formattedTime));
            out.flush();
            out.close();
            
        }
        
        
        
}
