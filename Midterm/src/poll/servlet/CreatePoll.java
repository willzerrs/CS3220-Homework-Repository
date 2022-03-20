package poll.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poll.model.PollEntries;

@WebServlet("/CreatePoll")
public class CreatePoll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreatePoll() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/CreatePoll.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PollEntries> pollsList = (List<PollEntries>) getServletContext().getAttribute("pollsList");
		pollsList.add(new PollEntries(request.getParameter("newQuestion")));
		
		request.getRequestDispatcher("/WEB-INF/Polls.jsp").forward(request, response);
	}

}
