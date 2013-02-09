package pl.edu.pk.wieik.pwj.presentation.controller;

import pl.edu.pk.wieik.pwj.presentation.model.Model;
import pl.edu.pk.wieik.pwj.presentation.model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/shownews")
public class ShowNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowNewsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<News> news = News.factory().getSortedNews();
		
		request.setAttribute("news", news);
		request.getRequestDispatcher("views/ShowNewsView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
