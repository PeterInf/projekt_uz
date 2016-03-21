package edu.projectuz.web.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "CalendarServlet",
        urlPatterns = "/calendars"
)
public class CalendarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String calendarJsp = "/views/calendarView.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(calendarJsp);
        dispatcher.forward(req, resp);
    }
}
