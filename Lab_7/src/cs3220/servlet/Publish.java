package cs3220.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Homework1Entry;


@WebServlet("/Publish")
public class Publish extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Publish() {
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
		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		Homework1Entry entry = getEntry(Integer.parseInt(request.getParameter("id")));
		entry.setPublished(true);
		entry.setDatePublish(format.format(localDate));
		response.sendRedirect("Homework1");
	}

}
