package lab9.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab9.model.MeetingsModel;

@WebServlet("/AddLink")
public class AddLink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddLink() {
    	super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MeetingsModel newClass = new MeetingsModel(request.getParameter("sectionName"), request.getParameter("zoomLink"));
		List<MeetingsModel> zoomLinks = (List<MeetingsModel>) getServletContext().getAttribute("zoomLinks");
		zoomLinks.add(newClass);
		response.sendRedirect("Meetings");
	}

}
