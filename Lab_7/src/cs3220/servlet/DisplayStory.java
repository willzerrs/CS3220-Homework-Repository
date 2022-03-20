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

@WebServlet("/DisplayStory")
public class DisplayStory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayStory() {
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
		response.setContentType("text/html");
		Homework1Entry entry = getEntry(Integer.parseInt(request.getParameter("id")));
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Display Story</title></head><body>");
		out.println("<p><a href='Homework1' style='text-decoration: none;'>Back to Stories</a><p>");
		out.println("<p><b>" + entry.getTitle() + "</b></p>");
		out.println("<p><i>" + entry.getSubtitle() + "</i></p>");
		out.println("<p>" + entry.getContent() + "</p>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
