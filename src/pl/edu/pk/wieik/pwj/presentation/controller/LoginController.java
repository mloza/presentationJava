package pl.edu.pk.wieik.pwj.presentation.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/LoginView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		// Check if filled
		if(login == null || login.equals("") || password == null || password.equals("")) {
			request.setAttribute("errorMsg", "Wszystkie pola muszą być uzupełnione!");
			request.setAttribute("login", login);
			request.getRequestDispatcher("views/LoginView.jsp").forward(request, response);
			return;
		}
		
		// Authenticate
		request.setAttribute("errorMsg", "Zalogowany ale jeszcze nie ma authentykacji!");
		request.getRequestDispatcher("views/LoginView.jsp").forward(request, response);
	}

}
