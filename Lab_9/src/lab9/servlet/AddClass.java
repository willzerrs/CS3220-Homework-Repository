package lab9.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab9.model.ClassModel;

@WebServlet("/AddClass")
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddClass() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/AddClass.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ClassModel> classList = (List<ClassModel>) getServletContext().getAttribute("classList");
		
		ClassModel newClass = new ClassModel(request.getParameter("className"));
		classList.add(newClass);
		
		getServletContext().setAttribute("classList", classList);
		response.sendRedirect("Meetings");
		
	}

}
