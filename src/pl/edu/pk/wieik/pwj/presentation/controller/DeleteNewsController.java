package pl.edu.pk.wieik.pwj.presentation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import pl.edu.pk.wieik.pwj.presentation.libs.ModelInt;
import pl.edu.pk.wieik.pwj.presentation.model.News;

@WebServlet("/deletenews")
public class DeleteNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteNewsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String newsToDeleteId = request.getParameter("id");
		
		try {
			News newsToDelete = (News) News.factory().get(Integer.parseInt(newsToDeleteId));
			decreaseNewsPositions(newsToDelete.getPosition());
			newsToDelete.delete();
		} catch(NumberFormatException e) {
			response.sendError(Response.SC_BAD_REQUEST);
			return;
		}
		
		
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/shownews"));
	}
	
	private void decreaseNewsPositions(int fromPosition) {
		List<News> news = News.factory().getSortedNews();
		News n = null;
		for(int idxInSortedList = fromPosition-1; idxInSortedList < news.size(); idxInSortedList++) {
			n = news.get(idxInSortedList);
			n.editPosition(n.getPosition() -1);
			n = null;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
