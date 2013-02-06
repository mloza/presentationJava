package pl.edu.pk.wieik.pwj.presentation.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.edu.pk.wieik.pwj.presentation.model.Authentication;
import pl.edu.pk.wieik.pwj.presentation.model.MD5;

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
		if(!checkIfAllFilled(login, password)) {
			request.setAttribute("errorMsg", "Wszystkie pola muszą być uzupełnione!");
			request.setAttribute("login", login);
			request.getRequestDispatcher("views/LoginView.jsp").forward(request, response);
			return;
		}
		
		// Authenticate
		Authentication authenticationService = new Authentication();
		boolean loggedIn = false;
		try {
			loggedIn = authenticationService.login(login, password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(loggedIn) {
			response.sendRedirect("/presentation/adminpane");
			return;
		} else {
			request.setAttribute("errorMsg", "Nieprawidłowy użytkownik lub hasło!");
			request.setAttribute("login", login);
			request.getRequestDispatcher("views/LoginView.jsp").forward(request, response);
			return;
		}
		
	}
	
	private boolean checkIfAllFilled(String ... parameters) {
		for(String param : parameters) {
			if(param == null || param.equals("")) {
				return false;
			}
		}
		
		return true;
	}

}
