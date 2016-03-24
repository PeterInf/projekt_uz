package edu.projectuz.web.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    private final Logger logger = LogManager.getLogger(CalendarServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.debug("Start Calendar Servlet");

        String calendarJsp = "/views/calendarView.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(calendarJsp);
        dispatcher.forward(req, resp);
    }
}
