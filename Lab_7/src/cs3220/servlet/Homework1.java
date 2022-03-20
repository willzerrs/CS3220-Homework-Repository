package cs3220.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Homework1Entry;

@WebServlet(urlPatterns="/Homework1", loadOnStartup = 1)
public class Homework1 extends HttpServlet {
	private static final long serialVersionUID = 1L;   

    public Homework1() {
        super();
        
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<Homework1Entry> entries = new ArrayList<Homework1Entry>();
		entries.add(new Homework1Entry("Apple Watch Series 6 Review", 
				"The Apple Watch is suffering from a lack of competitors, but it's also making its own.", 
				"Apple's latest smartwatch, the Apple Watch Series 6, gives us almost every feature one could ask for in a fitness tracker while reasserting Apple Watch's position as the most fun, connected, and complete smartwatch experience.",
				"9/27/2020", "9/27/2020", false));
		
		entries.add(new Homework1Entry("Battle of the $350 laptops", 
				"Neque porro quisquam est qui dolorem ipsum quia", 
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent non lacus varius nisl imperdiet mattis ac eget ex. In porttitor hendrerit libero non malesuada. Praesent sed feugiat enim. In egestas arcu quis erat condimentum mollis.",
				"9/25/2020", "9/27/2020", true));
		
		entries.add(new Homework1Entry("Google Maps gets a COVID-19 layer", 
				"Neque porro quisquam est qui dolorem ipsum quia", 
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent non lacus varius nisl imperdiet mattis ac eget ex. In porttitor hendrerit libero non malesuada. Praesent sed feugiat enim. In egestas arcu quis erat condimentum mollis.",
				"9/23/2020", "9/24/2020", true));
		
		getServletContext().setAttribute("entries", entries);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		List<Homework1Entry> entries = (List<Homework1Entry>) getServletContext().getAttribute("entries");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Homework1</title></head><body>");
		out.println("<p><a href='SubmitStory' style='text-decoration: none;'>Submit A Story</a></p>");
		out.println("<table border='1' style='border-collapse: collapse;'");
		out.println("<td><th>Story</th><th>Submitted</th><th>Published</th><th>Operations</th></td>");
		for(Homework1Entry entry: entries) {
			out.println("<tr>");
			out.println("<td><a href='DisplayStory?id=" + entry.getId() + "' style='text-decoration: none;'>" + entry.getTitle() + "</a></td>");
			out.println("<td>" + entry.getDateSubmit() + "</td>");
			if(entry.isPublished()) {
				out.println("<td>" + entry.getDatePublish() + "</td>");
			}
			else {
				out.println("<td><a href='Publish?id=" + entry.getId() + "' style='text-decoration: none;'>Publish</a></td>");
			}
			out.println("<td><a href='EditEntry?id="+ entry.getId() + "' style='text-decoration: none;'>Edit</a></td>");
			out.println("</tr>");
		}
		out.println("</table></body></html>");
		
	}

}
