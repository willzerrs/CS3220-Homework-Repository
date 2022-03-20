package poll.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poll.model.PollEntries;

@WebServlet("/Polls")
public class Polls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Polls() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		//create list storage
		List<PollEntries> pollsList = new ArrayList<PollEntries>();
		
		//fill list with premade stuff
		List<String> answers = new ArrayList<String>(Arrays.asList("Java", "Python", "C/C++"));
		PollEntries languages = new PollEntries("What programming languages do you know?");
		languages.setAnswers(answers);
		
		List<String> answers1 = new ArrayList<String>(Arrays.asList("Destiny 2", "Warframe", "Stardew Valley"));
    	PollEntries games = new PollEntries("Which games do you play?");
    	games.setAnswers(answers1);
    	
		pollsList.add(languages);
		pollsList.add(games);
    	getServletContext().setAttribute("pollsList", pollsList);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Polls.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
