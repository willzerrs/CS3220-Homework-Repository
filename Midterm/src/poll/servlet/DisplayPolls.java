package poll.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poll.model.PollEntries;

@WebServlet("/DisplayPolls")
public class DisplayPolls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayPolls() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PollEntries> pollsList = (List<PollEntries>) getServletContext().getAttribute("pollsList");
		Integer id = (Integer) request.getSession().getAttribute("id");
		List<PollEntries> filteredList = new ArrayList<PollEntries>();
		for(int i = 0; i < pollsList.size(); i++) {
			if(id == pollsList.get(i).getId()) {
				filteredList.add(pollsList.get(i));
			}
		}
		
		getServletContext().setAttribute("filteredList", filteredList);		
		request.getRequestDispatcher("/WEB-INF/DisplayPolls.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Polls.jsp").forward(request, response);
	}

}
