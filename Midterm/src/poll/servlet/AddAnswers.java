package poll.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poll.model.PollEntries;


@WebServlet("/AddAnswers")
public class AddAnswers extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddAnswers() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/AddAnswers.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = (Integer) request.getSession().getAttribute("id");
		List<PollEntries> pollsList = (List<PollEntries>) getServletContext().getAttribute("pollsList");
		PollEntries poll = null;
		for(int i = 0; i < pollsList.size(); i++) {
			if(id == pollsList.get(i).getId()) {
				poll = pollsList.get(i);
				break;
			}
		}
		
		List<String> answers = poll.getAnswers();
		answers.add(request.getParameter("newQuestion"));
		poll.setAnswers(answers);
		
		getServletContext().setAttribute("pollsList", pollsList);
		request.getRequestDispatcher("/WEB-INF/Poll.jsp").forward(request, response);
	}

}
