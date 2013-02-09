package pl.edu.pk.wieik.pwj.presentation.controller;

import pl.edu.pk.wieik.pwj.presentation.model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import java.io.IOException;

@WebServlet("/switchnewsposition")
public class SwitchNewsPositionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SwitchNewsPositionController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newsId1 = request.getParameter("id1");
		String newsId2 = request.getParameter("id2");
		
		// Check if filled
		if(newsId1 == null || newsId1.equals("") || newsId2 == null || newsId2.equals("")) {
			response.sendError(Response.SC_BAD_REQUEST);
			return;
		}
		
		try {
			News news1 = (News) News.factory().get(Integer.parseInt(newsId1));
			News news2 = (News) News.factory().get(Integer.parseInt(newsId2));
			
			// Switch news1 and news2 positions
			int oldNews1Pos = news1.getPosition();
			news1.editPosition(news2.getPosition());
			news2.editPosition(oldNews1Pos);
			
		} catch(NumberFormatException e) {
			response.sendError(Response.SC_BAD_REQUEST);
			return;
		}
		
		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/shownews"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
