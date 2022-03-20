package lab12.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab12.model.Department;
import lab12.model.Faculty;
import lab12.service.DbService;

@WebServlet("/AddFaculty")
public class AddFaculty extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddFaculty()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
    	DbService dbService = new DbService();
    	request.setAttribute( "departments", dbService.getDepartmentEntries());
    	dbService.close();
        request.getRequestDispatcher( "/WEB-INF/AddFaculty.jsp" )
            .forward( request, response );
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        String departmentName = request.getParameter( "department" );
        boolean isChair = false;
        if( request.getParameter( "chair" ) != null ) {
        	isChair = true ;
        }

        DbService dbService = new DbService();
        dbService.addFacultyEntry(request.getParameter("faculty"), departmentName, isChair);
        dbService.close();
        
        response.sendRedirect( "DisplayFaculty" );
    }

}
