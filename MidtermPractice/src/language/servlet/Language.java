package language.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import language.model.LanguageModel;

@WebServlet("/Language")
public class Language extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Language() {
    	super();
    }

    public void init(ServletConfig config) throws ServletException {	
		super.init(config);
		
		List<LanguageModel> languageList = new ArrayList<LanguageModel>();
    	languageList.add(new LanguageModel("Java", 5));
    	languageList.add(new LanguageModel("Python", 3));
    	languageList.add(new LanguageModel("JavaScript", 4));
    	
    	getServletContext().setAttribute("languageList", languageList);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/Poll.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Handles selected languages from poll jsp and redirects to display results
		
		//Increment responseCounter for selected languages
		List<LanguageModel> languageList = (List<LanguageModel>) getServletContext().getAttribute("languageList");
//		String[] checkedIds = request.getParameterValues("checkedLanguages");
//		for(int i = 0; i < languageList.size(); i++) {
//			if(String.valueOf(languageList.get(i).getId()).equals(checkedIds[i])){
//				int counter = languageList.get(i).getResponseCounter();
//				languageList.get(i).setResponseCounter(counter++);
//			}
//		}
//		getServletContext().setAttribute("languageList", languageList);
		
		request.getRequestDispatcher("/WEB-INF/Language.jsp").forward(request, response);
	}

}
