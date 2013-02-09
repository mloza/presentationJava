package pl.edu.pk.wieik.pwj.presentation.controller;

import pl.edu.pk.wieik.pwj.presentation.model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import java.io.IOException;

@WebServlet("/editnews")
public class EditNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditNewsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		News newsToEdit = null;
		
		// Check if got needed parameters
		if(id == null || id.equals("")) {
			response.sendError(Response.SC_BAD_REQUEST);
			return;
		}
		
		try {
			newsToEdit = (News) News.factory().get(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			response.sendError(Response.SC_BAD_REQUEST);
			return;
		}
		
		request.setAttribute("news", newsToEdit);
		request.getRequestDispatcher("views/EditNewsView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		
		if(!checkIfFilled(content)) {
			request.setAttribute("errorMsg", "Należy uzupełnić wymagane pola.");
			request.getRequestDispatcher("views/EditNewsView.jsp").forward(request, response);
			return;
		}
		
		try {
			News newsToEdit = (News) News.factory().get(Integer.parseInt(id));
			newsToEdit.editContent(content);
		} catch(NumberFormatException e) {
			response.sendError(Response.SC_BAD_REQUEST);
			return;
		}
		
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/shownews"));
	}
	
	private boolean checkIfFilled(String content) {
		if(content == null || content.equals("")) {
			return false;
		}
		
		return true;
	}

}
