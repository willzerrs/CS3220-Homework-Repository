package lab12.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab12.service.DbService;

@WebServlet("/AddDepartment")
public class AddDepartment extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddDepartment()
    {
        super();
    }

    protected void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        request.getRequestDispatcher( "/WEB-INF/AddDepartment.jsp" )
            .forward( request, response );;
    }

    protected void doPost( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException
    {
        
        DbService dbService = new DbService();
        dbService.addDepartmentEntry(request.getParameter("name"));
        dbService.close();
        
        response.sendRedirect( "DisplayFaculty" );
    }

}
