package lab9.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab9.model.MeetingsModel;

@WebServlet("/DeleteLink")
public class DeleteLink extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteLink() {
        super();
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		MeetingsModel entry = null;
		List<MeetingsModel> zoomLinks = (List<MeetingsModel>) getServletContext().getAttribute("zoomLinks");
		for(MeetingsModel e : zoomLinks )
            if(e.getId() == id)
            {
                entry = e;
                break;
            }

        if(entry != null) zoomLinks.remove(entry);
        response.sendRedirect("Meetings");
	}

}
