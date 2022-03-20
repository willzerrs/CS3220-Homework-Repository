package lab9.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab9.model.ClassModel;
import lab9.model.MeetingsModel;


@WebServlet("/Meetings")
public class Meetings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Meetings() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//List containing all the list of zoom links and its corresponding class name(e.g. CS3220).
		List<ClassModel> classList = new ArrayList<ClassModel>();
		
		ClassModel class1 = new ClassModel("CS3220");
		MeetingsModel section1 = new MeetingsModel("Lecture", "https://calstatela.zoom.us/j/12345");
		MeetingsModel section2 = new MeetingsModel("Lab", "https://calstatela.zoom.us/j/23456");
		List<MeetingsModel> zoomLinks = new ArrayList<MeetingsModel>();
		zoomLinks.add(section1);
		zoomLinks.add(section2);		
		class1.setZoomLinks(zoomLinks);
		classList.add(class1);
		
		getServletContext().setAttribute("classList", classList);
		getServletContext().setAttribute("zoomLinks", zoomLinks);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = (Integer) request.getSession().getAttribute("id");
		if (id == null) {
			request.getSession().setAttribute("id", 1);
		}
		else {
			request.getSession().setAttribute("id", id);
		}

		request.getRequestDispatcher("/WEB-INF/ClassList.jsp").forward(request, response);
	}

//	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		List<ClassModel> classList = (List<ClassModel>) getServletContext().getAttribute("classList");
//		List<MeetingsModel> zoomLinks = (List<MeetingsModel>) getServletContext().getAttribute("zoomLinks");
//		Integer id = (Integer) request.getSession().getAttribute("id");
		String selectedClass = request.getParameter("selectedClass");
//		for(int i = 0; i < classList.size(); i++) {
//			if(zoomLinks.get(i).getId() == classList.get(i).getId()) {
//				
//			}
//		}
//		request.getSession().setAttribute("id", id);
		request.getSession().setAttribute("currentName", selectedClass);
//		getServletContext().setAttribute("entries", entries);
//		request.getRequestDispatcher("/WEB-INF/ClassList.jsp").forward(request, response);
		doGet(request, response);
	}
}
