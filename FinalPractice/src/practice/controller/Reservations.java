package practice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import practice.service.DbService;

@WebServlet("/Reservations")
public class Reservations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Reservations() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbService dbService = new DbService();
    	request.setAttribute( "entries", dbService.getReservations());
    	dbService.close();
    	
        request.getRequestDispatcher( "/WEB-INF/DisplayReservations.jsp" )
            .forward( request, response );
	}

}
