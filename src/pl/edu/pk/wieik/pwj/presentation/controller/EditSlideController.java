package pl.edu.pk.wieik.pwj.presentation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.edu.pk.wieik.pwj.presentation.model.Slide;

@WebServlet("/editslide")
public class EditSlideController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EditSlideController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/EditSlideView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action") != null) {
			if(request.getParameter("action").equals("edit")) {
				Integer slideID = Integer.valueOf(request.getParameter("slideID"));
				Integer presentationID = Integer.valueOf(request.getParameter("presentationID"));
				Slide slide = Slide.factory().get(slideID);
				request.setAttribute("slide", slide);
				request.setAttribute("presentationID", presentationID);
				doGet(request, response);
				return;
			}
		}
		if(request.getParameter("action") != null) {
			if(request.getParameter("action").equals("edittedSlide")) {
				Integer presentationID = Integer.valueOf(request.getParameter("presentationID"));
				Integer slideID = Integer.valueOf(request.getParameter("slideID"));
				String description = request.getParameter("description");
				Integer duration = Integer.valueOf(request.getParameter("duration"));
				System.out.println("PRES ID: " + presentationID + " SlideID: " + slideID + ", description: " + description + ", duration: " + duration );
				Slide slide = Slide.factory().get(slideID);
				slide.update(slideID, description, duration);
				request.getRequestDispatcher("/slideorder").forward(request, response);
				return;
			}
			
		}
	}

}
