package language.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import language.model.LanguageModel;

@WebServlet("/AddLanguage")
public class AddLanguage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddLanguage() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/AddLanguage.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<LanguageModel> languageList = (List<LanguageModel>) getServletContext().getAttribute("languageList");
		//		String languageName = ;
		languageList.add(new LanguageModel(request.getParameter("languageName"), 0));
		getServletContext().setAttribute("languageList", languageList);

		request.getRequestDispatcher("/WEB-INF/Poll.jsp").forward(request, response);
	}

}
