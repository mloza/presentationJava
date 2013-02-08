package pl.edu.pk.wieik.pwj.presentation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.edu.pk.wieik.pwj.presentation.model.Model;
import pl.edu.pk.wieik.pwj.presentation.model.News;

@WebServlet("/shownews")
public class ShowNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowNewsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Wczytywanie newsów z bazy
//		List<News> news = new ArrayList<News>();
//		news.add(new News(1, "Testowy News Pierwszy", new java.sql.Date(2000, 11, 12), 1));
//		news.add(new News(2, "Testowy News Drugi", new java.sql.Date(2000, 10, 11), 2));
		
		List<Model> news = News.factory().getAll();
		
		request.setAttribute("news", news);
		request.getRequestDispatcher("views/ShowNewsView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
