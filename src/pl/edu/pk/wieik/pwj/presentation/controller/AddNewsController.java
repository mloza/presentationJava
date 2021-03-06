package pl.edu.pk.wieik.pwj.presentation.controller;

import pl.edu.pk.wieik.pwj.presentation.model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addnews")
public class AddNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddNewsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/AddNewsView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String content = request.getParameter("content");
		
		if(!checkIfFilled(content)) {
			request.setAttribute("errorMsg", "Należy uzupełnić wymagane pola.");
			request.getRequestDispatcher("views/AddNewsView.jsp").forward(request, response);
			return;
		}
		
		News newsToAdd = News.factory();
		newsToAdd.setContent(content);
		newsToAdd.setDate(new java.sql.Date(new java.util.Date().getTime()));
		newsToAdd.save();
		
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/shownews"));
	}
	
	private boolean checkIfFilled(String content) {
		if(content == null || content.equals("")) {
			return false;
		}
		
		return true;
	}

}
