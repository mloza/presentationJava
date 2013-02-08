package pl.edu.pk.wieik.pwj.presentation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.edu.pk.wieik.pwj.presentation.model.News;

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
		String date = request.getParameter("date");
		
		// TODO Walidacja formularza
		
		News newsToAdd = News.factory();
		newsToAdd.setContent(content);
		newsToAdd.setDate(new java.sql.Date(1900, 2, 2));
		newsToAdd.setPosition(2);
		newsToAdd.save();
	}

}
