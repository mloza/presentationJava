package pl.edu.pk.wieik.pwj.presentation.controller;

import pl.edu.pk.wieik.pwj.presentation.libs.ModelInt;
import pl.edu.pk.wieik.pwj.presentation.model.News;
import pl.edu.pk.wieik.pwj.presentation.model.Presentation;
import pl.edu.pk.wieik.pwj.presentation.model.Slide;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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

    	
    	//tests
//        Presentation p = Presentation.factory().get(1);
//        
//        Presentation p2 = Presentation.factory();
//        p2.setId(2);
//        p2.setName("prezentacja2");
//      
//        
//        Slide sl = Slide.factory();
//        sl.setDuration(15);
//        sl.setPosition(5);
//        sl.setType(SlideType.HTML);
//        
//        Slide sl2 = Slide.factory();
//        sl2.setDuration(111);
//        sl2.setPosition(222);
//        sl2.setType(SlideType.IMAGE);
//        
//        Slide sl3 = Slide.factory();
//        sl3.setDuration(777);
//        sl3.setPosition(666);
//        sl3.setType(SlideType.VIDEO);
//        
//                
//        List<Slide> slides = p2.getSlides();
//        slides.add(sl);
//        slides.add(sl2);
//        slides.add(sl3);
//        
//        p2.save();
        

//        PrintWriter out = response.getWriter();
//        News news = News.factory();
//        for(ModelInt i: news.getAll()) {
//            out.write(((News)i).getContent());
//        }
//
//        Presentation presentation = Presentation.factory();
//        for(ModelInt i: presentation.getAll()) {
//            out.write(((Presentation)i).getName());
//            for(Slide j: ((Presentation)i).getSlides()) {
//                out.write(j.getType().name());
//            }
//        }
//
//
//       news.remove();
     
//    	news.setContent("to jest wiadmosoc");
//    	news.setPosition(5);
//    	news.setDate(new java.sql.Date(15));
//    	news.save();
    	
    	//news.editContent(1, "poprawka");
        //Presentation list = Presentation.factory();
        //list.getAll();
        /*for(Presentation p : list.getAll()){
        	System.out.println(p.getName());
        } */
        
      
       // news.getAll();
        
        
//        News n = News.factory();
//        n.setContent("trolololotrololo");
//    	n.setDate(new java.sql.Date(15));
//        n.save();
    	
    	Slide sl = Slide.factory();
    	sl = sl.getByPosition(1, 1);
    	sl.removeSlide(1);
    	
    	
        //end tests
        //p.getSlides();

        //request.setAttribute("p", p);

       /* List<Slide> s = Slide.factory().getAll(1);

        request.getRequestDispatcher("views/main/index.jsp").forward(request, response);*/
    }

}
