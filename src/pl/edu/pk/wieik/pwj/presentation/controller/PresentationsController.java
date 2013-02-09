package pl.edu.pk.wieik.pwj.presentation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.edu.pk.wieik.pwj.presentation.libs.ModelInt;
import pl.edu.pk.wieik.pwj.presentation.model.Model;
import pl.edu.pk.wieik.pwj.presentation.model.Presentation;
import pl.edu.pk.wieik.pwj.presentation.model.Slide;
import pl.edu.pk.wieik.pwj.presentation.util.SlidesPositionComparator;

@WebServlet("/presentations")
public class PresentationsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PresentationsController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession(false); // autentykacja
		if(session == null) {
			request.setAttribute("msg", "Sesja wygasła - zaloguj się ponownie.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}*/		
		List<Model> models = Presentation.factory().getAll();
		List<Presentation> presentations = new ArrayList<Presentation>();
		for (Model i : models) {
			presentations.add((Presentation)i);
		}
		request.setAttribute("presentations", presentations);
		request.getRequestDispatcher("views/PresentationsView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action") != null) {
			if(request.getParameter("action").equals("editPresentation")) {
				request.getRequestDispatcher("/slideorder").forward(request, response);
				return;				
			}
			if(request.getParameter("action").equals("delete")) {
				// dodać usuwanie prezentacji				
			}
		}
		request.setAttribute("msg", "Nieznany błąd. Spróbuj ponownie.");
		request.getRequestDispatcher("_errors/error.jsp").forward(request, response);
	}

}
