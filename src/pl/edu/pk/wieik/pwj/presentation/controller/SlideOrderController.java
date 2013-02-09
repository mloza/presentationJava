package pl.edu.pk.wieik.pwj.presentation.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import pl.edu.pk.wieik.pwj.presentation.model.Presentation;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pl.edu.pk.wieik.pwj.presentation.model.Slide;
import pl.edu.pk.wieik.pwj.presentation.util.SlidesPositionComparator;

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
		request.getRequestDispatcher("views/SlideOrderView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession(false); // autentykacja
		if(session == null) {
			request.setAttribute("msg", "Sesja wygasła - zaloguj się ponownie.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}*/	
		if(request.getParameter("action") != null) {
			// powrót z EditSlideController lub żądanie wyświetlenia listy slajdów
			if(request.getParameter("action").equals("editPresentation") || request.getParameter("action").equals("edittedSlide")) {
				Integer presentationID = Integer.valueOf(request.getParameter("presentationID"));
				List<Slide> slides = Presentation.factory().get(presentationID).getSlides();
				Collections.sort(slides, new SlidesPositionComparator()); 
				request.setAttribute("slides", slides);
				request.setAttribute("presentationID", presentationID);
				doGet(request, response);
			}
			if(request.getParameter("action").equals("up")) { // przesunięcie slajdu o jedną pozycję do góry
				Integer slideID = Integer.valueOf(request.getParameter("slideID"));
				Integer slidePos = Integer.valueOf(request.getParameter("slidePos"));
				Integer presentationID = Integer.valueOf(request.getParameter("presentationID"));
				Slide earlierSlide = Slide.factory().getByPosition(presentationID, slidePos-1); // pobranie slajdu o pozycji o 1 mniejszej
				Slide.factory().editPosition(earlierSlide.getId(), slidePos.toString()); // przypisanie do poprzedniego slajdu obecnej pozycji
				slidePos -= 1; // cofnięcie pozycji o 1
				Slide.factory().editPosition(slideID, slidePos.toString()); // przypisanie aktualnemu pozycji o 1 większej
				List<Slide> slides = Presentation.factory().get(presentationID).getSlides();
				Collections.sort( slides, new SlidesPositionComparator()); 
				request.setAttribute("slides", slides);
				request.setAttribute("presentationID", presentationID);
				doGet(request, response);
			}
			if(request.getParameter("action").equals("down")) { // przesunięcie slajdu o jedną pozycję w dół
				Integer slideID = Integer.valueOf(request.getParameter("slideID"));
				Integer slidePos = Integer.valueOf(request.getParameter("slidePos"));
				Integer presentationID = Integer.valueOf(request.getParameter("presentationID"));
				Slide laterSlide = Slide.factory().getByPosition(presentationID, slidePos+1); // pobranie slajdu o pozycji o 1 większej
				Slide.factory().editPosition(laterSlide.getId(), slidePos.toString()); // przypisanie do następnego slajdu obecnej pozycji
				slidePos += 1; // zwiększenie pozycji o 1
				Slide.factory().editPosition(slideID, slidePos.toString()); // przypisanie aktualnemu pozycji o 1 mniejszej
				List<Slide> slides = Presentation.factory().get(presentationID).getSlides();
				Collections.sort( slides, new SlidesPositionComparator()); 
				request.setAttribute("slides", slides);
				request.setAttribute("presentationID", presentationID);
				doGet(request, response);
			}
			if(request.getParameter("action").equals("edit")) {	// edycja slajdu
				request.getParameter("slideID");
				request.getRequestDispatcher("/editslide").forward(request, response);
				return;				
			}
			if(request.getParameter("action").equals("delete")) { // usunięcie slajdu
				Integer presentationID = Integer.valueOf(request.getParameter("presentationID"));
				request.getParameter("slideID");
				request.setAttribute("presentationID", presentationID);
				request.getRequestDispatcher("/editslide").forward(request, response);
				return;		
			}
		}
		
	}
}
