package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Homework1Entry;

@WebServlet("/SubmitStory")
public class SubmitStory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SubmitStory() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Submit Story</title></head><body>");
		out.println("<form action='SubmitStory' method='post'>");
		out.println("Title: <input type='text' name='title' rows='6'><br>");
		out.println("Subtitle: <input type='text' name='subtitle' rows='6'><br>");
		out.println("Content: <textarea name='content' rows='6' cols='40'></textarea><br>");
		out.println("<button>Submit</button></form>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/dd/yyyy");
		LocalDate localDate = LocalDate.now();
		String title = request.getParameter("title");
		String subtitle = request.getParameter("subtitle");
		String content = request.getParameter("content");
		String dateSubmit = format.format(localDate);
		String datePublish = format.format(localDate);
		Homework1Entry entry = new Homework1Entry(title, subtitle, content, dateSubmit, datePublish, false);
		@SuppressWarnings("unchecked")
		List<Homework1Entry> entries = (List<Homework1Entry>) getServletContext().getAttribute("entries");
		entries.add(0, entry);
		response.sendRedirect("Homework1");
	}

}
