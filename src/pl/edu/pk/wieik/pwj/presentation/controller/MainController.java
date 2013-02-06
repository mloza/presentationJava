package pl.edu.pk.wieik.pwj.presentation.controller;

import pl.edu.pk.wieik.pwj.presentation.model.Presentation;
import pl.edu.pk.wieik.pwj.presentation.model.Slide;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: scroot
 * Date: 06.02.13
 * Time: 14:02
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "Main Controller", urlPatterns = {"/index.html"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

<<<<<<< HEAD
        Presentation p = Presentation.factory().get(1);
        
        Presentation p2 = Presentation.factory();
        p2.setId(2);
        p2.setName("prezentacja2");
        p2.save();
        
        
=======
        //Presentation p = Presentation.factory().get(1);
>>>>>>> 54eef58d1f1199bd73fcc441e318817bffbcc997

        //p.getSlides();

        //request.setAttribute("p", p);

        List<Slide> s = Slide.factory().getAll(1);

        request.getRequestDispatcher("views/main/index.jsp").forward(request, response);
    }

}
