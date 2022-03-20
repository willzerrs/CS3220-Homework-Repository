package lab12.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab12.model.Department;
import lab12.service.DbService;

@WebServlet(urlPatterns = "/DisplayFaculty", loadOnStartup = 1)
public class DisplayFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public DisplayFaculty()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	DbService dbService = new DbService();
    	request.setAttribute( "departments", dbService.getDepartmentEntries());
    	dbService.close();
    	
        request.getRequestDispatcher( "/WEB-INF/DisplayFaculty.jsp" )
            .forward( request, response );
    }
    
}
