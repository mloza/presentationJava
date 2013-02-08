package pl.edu.pk.wieik.pwj.presentation.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: scroot
 * Date: 06.02.13
 * Time: 17:41
 * To change this template use File | Settings | File Templates.
 */
public class ImageSlide extends SlideExtend {
    protected Integer id;
    protected String description;
    protected Integer width;
    protected Integer height;
    protected String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public SlideExtend load(ResultSet res) throws SQLException {
        this.id = res.getInt("i:id");
        this.description = res.getString("i:description");
        this.path = res.getString("i:path");
        this.width = res.getInt("i:width");
        this.height = res.getInt("i:height");
        return this;
    }

    public void save(){
        try {
            String insert = "INSERT INTO imageSlide (description, width, height, path) values (?, ?, ?, ?) ";
            java.sql.PreparedStatement st = DB.prepareStatement(insert);
            st.setString(1, this.getDescription());
            st.setInt(2, this.getWidth());
            st.setInt(3, this.getHeight());
            st.setString(4, this.getPath());
            st.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void editDescription(Integer imageSlideId, String newDescription){
        try{
            String update = "UPDATE imageSlide SET description = ? WHERE id = ? ";
            PreparedStatement st = DB.prepareStatement(update);
            st.setString(1, newDescription);
            st.setInt(2, imageSlideId);
            st.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void editWidth(Integer imageSlideId, Integer newWidth){
        try{
            String update = "UPDATE imageSlide SET width = ? WHERE id = ? ";
            PreparedStatement st = DB.prepareStatement(update);
            st.setInt(1, newWidth);
            st.setInt(2, imageSlideId);
            st.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void editHeight(Integer imageSlideId, Integer newHeight){
        try{
            String update = "UPDATE imageSlide SET height = ? WHERE id = ? ";
            PreparedStatement st = DB.prepareStatement(update);
            st.setInt(1, newHeight);
            st.setInt(2, imageSlideId);
            st.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void editPath(Integer imageSlideId, String newPath){
        try{
            String update = "UPDATE imageSlide SET path = ? WHERE id = ? ";
            PreparedStatement st = DB.prepareStatement(update);
            st.setString(1, newPath);
            st.setInt(2, imageSlideId);
            st.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
