package pl.edu.pk.wieik.pwj.presentation.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.edu.pk.wieik.pwj.presentation.model.Presentation;
import pl.edu.pk.wieik.pwj.presentation.model.Slide;

/**
 * Servlet implementation class PresentationOrderController
 */
@WebServlet("/presentations")
public class PresentationsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PresentationsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession(false); // autentykacja
		if(session == null) {
			request.setAttribute("msg", "Sesja wygasła - zaloguj się ponownie.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}*/	
		Integer presentationID = Integer.valueOf(request.getParameter("presentationID"));
		Presentation presentation = Presentation.factory().get(presentationID);
		List<Slide> slides = presentation.getSlides();
		request.setAttribute("slides", slides);
		request.getRequestDispatcher("views/SlideOrderView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession(false); // autentykacja
		if(session == null) {
			request.setAttribute("msg", "Sesja wygasła - zaloguj się ponownie.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}*/	
		request.getRequestDispatcher("views/PresentationsView.jsp").forward(request, response);
		
	}

}
