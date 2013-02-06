package pl.edu.pk.wieik.pwj.presentation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bartek
 */
@WebServlet(name = "AdminPanel", urlPatterns = {"/AdminPanel"})
public class AdminPanel extends HttpServlet {
    /** 
     * Przetwarzanie żądań HTTP get i HTTP post
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException jeśli wystąpi specyficzny dla serwletu błąd
     * @throws IOException jeśli wystąpi błąd wejścia/ wyjścia
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
		if(session == null) {
			request.setAttribute("msg", "Sesja wygasła - zaloguj się ponownie.");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			return;
		}
                /* 
                 * pobranie z bazy listy i wrzucenie jej do requesta 
                 */         
    }
    
    /** 
     * Odbiera żądanie HTTP get
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException jeśli wystąpi specyficzny dla serwletu błąd
     * @throws IOException jeśli wystąpi błąd wejścia/ wyjścia
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Odbiera żądanie HTTP post
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException jeśli wystąpi specyficzny dla serwletu błąd
     * @throws IOException jeśli wystąpi błąd wejścia/ wyjścia
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Zwraca krótki opis serwletu
     * @return String zawierający opis serwletu
     */
    @Override
    public String getServletInfo() {
        return "PWJ: Prezentacje: Serwlet - AdminPanel, twórca: Bartosz Górecki";
    }
}
