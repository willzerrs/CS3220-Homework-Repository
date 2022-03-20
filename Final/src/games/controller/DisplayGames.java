package games.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import games.service.DbService;

@WebServlet(urlPatterns = "/DisplayGames", loadOnStartup = 1)
public class DisplayGames extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayGames() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbService dbService = new DbService();
    	request.setAttribute( "games", dbService.getGames());
    	request.setAttribute( "reviews", dbService.getReviews());
    	dbService.close();
    	
        request.getRequestDispatcher( "/WEB-INF/DisplayGames.jsp" )
            .forward( request, response );
	}

}
