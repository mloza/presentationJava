package pl.edu.pk.wieik.pwj.presentation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.edu.pk.wieik.pwj.presentation.model.Presentation;
import pl.edu.pk.wieik.pwj.presentation.model.Slide;

@WebServlet("/slideorder")
public class SlideOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SlideOrderController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession(false); // autentykacja
		if(session == null) {
			request.setAttribute("msg", "Sesja wygasła - zaloguj się ponownie.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}*/		
		if(request.getParameter("action") != null) {
			if(request.getParameter("action").equals("edit")) {
				// dodać edycję prezentacji			
				Integer presentationID = Integer.valueOf(request.getParameter("presentationID"));
				Presentation presentation = Presentation.factory().get(presentationID);
				request.setAttribute("presentation", presentation);
				request.getRequestDispatcher("views/SlideOrderView.jsp").forward(request, response);
				return;
			}
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession(false); // autentykacja
		if(session == null) {
			request.setAttribute("msg", "Sesja wygasła - zaloguj się ponownie.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}*/	
		request.getRequestDispatcher("views/SlideOrderView.jsp").forward(request, response);
	}
}
