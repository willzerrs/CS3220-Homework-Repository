

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdditionPractice
 */
@WebServlet("/AdditionPractice")
public class AdditionPractice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdditionPractice() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Random random = new Random();
		int x = random.nextInt(9) + 1;
		int y = random.nextInt(9) + 1;
		out.print("<html><head><title>AdditionPractice</title></head><body>");
		out.print("<form action='AdditionPractice' method='post'>");
		out.print(x + " + " + y + " = ");
		out.print("<input type='hidden' name='x' value='" + x + "'>");
		out.print("<input type='hidden' name='y' value='" + y + "'>");
		out.print("<input type='text' name='answer'>");
		out.print("<button>Submit</button>");
		out.print("</form></body></html>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int sum = x + y;
		out.println(x + " + " + y + " = " + sum);
		int ans = Integer.parseInt(request.getParameter("answer"));
		out.print("<html><head><title>AdditionResults</title></head><body>");
		if (sum == ans) {
			out.print("<p>Your answer " + ans + " is correct.</p>");
		}
		else {
			out.print("<p>Your answer " + ans + " is incorrect.</p>");
		}
		out.print("<p><a href='AdditionPractice'>Try again</a></p>\n");
		out.println("</body></html>");
	}

}
