package games.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import games.service.DbService;

@WebServlet("/DisplayReviews")
public class DisplayReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayReviews() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DbService dbService = new DbService();
    	request.setAttribute( "reviews", dbService.getReviews());
    	dbService.close();
    	
		request.getRequestDispatcher( "/WEB-INF/DisplayReviews.jsp" )
        .forward( request, response );
	}

}
