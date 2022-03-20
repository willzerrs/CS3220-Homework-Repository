package cs3220.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.QuestionModel;

@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DrivingTestBrowser() {
		super();
	}

	public void init() throws ServletException {
		super.init();
		String filePath = getServletContext().getRealPath("/WEB-INF/DrivingTest.txt");
		Scanner in;
		//    	getServletContext().setAttribute("nextIndex", 0);
		List<QuestionModel> questionList = new ArrayList<QuestionModel>();
		try {
			in = new Scanner(new File(filePath));
			while (in.hasNextLine()) {
				String description = in.nextLine();
				String answerA = in.nextLine();
				String answerB = in.nextLine();
				String answerC = in.nextLine();
				int correctAnswer = Integer.parseInt(in.nextLine());
				in.nextLine();
				QuestionModel model = new QuestionModel(description, answerA, answerB, 
						answerC, correctAnswer);
				questionList.add(model);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		getServletContext().setAttribute("questionList", questionList);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")	
		List<QuestionModel> questionList = (List<QuestionModel>) getServletContext().getAttribute("questionList");

		if (request.getParameter("nextIndex") == null) {
			request.getSession().setAttribute("nextIndex", 0);
		}
		else {
			int nextIndex = Integer.parseInt(request.getParameter("nextIndex"));
			if (nextIndex < questionList.size()) {
				getServletContext().setAttribute("nextIndex", nextIndex);
			}
			else {
				getServletContext().setAttribute("nextIndex", 0);
			}
		}

		request.getRequestDispatcher("/WEB-INF/Question.jsp?nextIndex=" + getServletContext().getAttribute("nextIndex")).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
