package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Homework1Entry;

@WebServlet("/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditEntry() {
        super();

    }

    private Homework1Entry getEntry(int id) {
    	@SuppressWarnings("unchecked")
		List<Homework1Entry> entries = (List<Homework1Entry>) getServletContext().getAttribute("entries");
		for(Homework1Entry entry : entries)
			if(entry.getId() == id) return entry;
		return null;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Homework1Entry entry = getEntry(Integer.parseInt(request.getParameter("id")));
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Edit Entry</title></head><body>");
		out.println("<form method='post'>");
		out.println("Title: <input type='text' name='title' rows='6' value='" + entry.getTitle() + "'><br>");
		out.println("Subtitle: <input type='text' name='subtitle' rows='6' value='" + entry.getSubtitle() + "'><br>");
		out.println("Content: <textarea name='content' rows='6' cols='40'>" + entry.getContent() + "</textarea><br>");
		out.println("<button>Save</button></form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Homework1Entry entry = getEntry(Integer.parseInt(request.getParameter("id")));
		entry.setTitle(request.getParameter("title"));
		entry.setSubtitle(request.getParameter("subtitle"));
		entry.setContent(request.getParameter("content"));
		response.sendRedirect("Homework1");
	}

}
