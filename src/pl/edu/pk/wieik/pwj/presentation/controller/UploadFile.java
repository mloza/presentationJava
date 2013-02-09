package pl.edu.pk.wieik.pwj.presentation.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import pl.edu.pk.wieik.pwj.presentation.model.ImageSlide;
import pl.edu.pk.wieik.pwj.presentation.model.VideoSlide;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
 
@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIRECTORY = "upload";
    private static final int THRESHOLD_SIZE = 1024 * 1024 * 3; // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
     
        if (!ServletFileUpload.isMultipartContent(request)) {
        
            return;
        }
     
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(THRESHOLD_SIZE);
        //ustawic sciezke do zapisu
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
         
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(REQUEST_SIZE);
         
        
        String uploadPath = getServletContext().getRealPath("")
            + File.separator + UPLOAD_DIRECTORY;
     
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
      
        try {
          
            List formItems = upload.parseRequest(request);
            Iterator iter = formItems.iterator();
             
           
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
               
                if (!item.isFormField()) {
                    String fileName = new File(item.getName()).getName();
                    String filePath = uploadPath + File.separator + fileName;
                    File storeFile = new File(filePath);
                    System.out.println(filePath);
                 
                    item.write(storeFile);

                    String extension = item.getName().substring(item.getName().lastIndexOf('.') + 1);
                    System.out.println(extension);
                    for (ImageFileTypes type : ImageFileTypes.values()) {
                        if (type.name().equals(extension)) {
                            //zapis obrazka
                            ImageSlide imgToAdd = ImageSlide.factory();
                            imgToAdd.setDescription("opis");
                            imgToAdd.setWidth(1);
                            imgToAdd.setHeight(1);
                            imgToAdd.setPath(filePath);
                            imgToAdd.save();
                            break;
                        }
                    }
                    for (VideoFileTypes type : VideoFileTypes.values()) {
                        if (type.name().equals(extension)) {
                            //zapis filmu
                            VideoSlide vidToAdd = VideoSlide.factory();
                            vidToAdd.setName(fileName);
                            vidToAdd.setDescription("opis");
                            vidToAdd.setFps(1);
                            vidToAdd.setFormat(extension);
                            vidToAdd.setPath(filePath);
                            vidToAdd.save();
                            break;
                        }
                    }
                }
            }
            request.setAttribute("message", "Upload has been done successfully!");
        } catch (Exception ex) {
            request.setAttribute("message", "There was an error: " + ex.getMessage());
        }


        getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
    }
    private enum ImageFileTypes{
         jpg, gif, png, jpeg, bmp, jfif, tif, tiff;
    }
    private enum VideoFileTypes{
         mpg, mpeg, avi, mov, qt, vob;
    }
}