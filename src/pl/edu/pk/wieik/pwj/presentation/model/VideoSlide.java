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
public class VideoSlide extends SlideExtend {
    protected Integer id;
    protected String name;
    protected Integer fps;
    protected String format;
    protected String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFps() {
        return fps;
    }

    public void setFps(Integer fps) {
        this.fps = fps;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public SlideExtend load(ResultSet res) throws SQLException {
        this.id = res.getInt("v:id");
        this.name = res.getString("v:name");
        this.path = res.getString("v:path");
        this.fps = res.getInt("v:fps");
        this.format = res.getString("v:format");
        return this;
    }

    public void save(){
        try {
            String insert = "INSERT INTO videoSlide (name, fps, format, path) values (?, ?, ?, ?) ";
            java.sql.PreparedStatement st = DB.prepareStatement(insert);
            st.setString(1, this.getName());
            st.setInt(2, this.getFps());
            st.setString(3, this.getFormat());
            st.setString(4, this.getPath());
            st.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void editName(Integer videoSlideId, String newName){
        try{
            String update = "UPDATE videoSlide SET name = ? WHERE id = ? ";
            PreparedStatement st = DB.prepareStatement(update);
            st.setString(1, newName);
            st.setInt(2, videoSlideId);
            st.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void editFps(Integer videoSlideId, Integer newFps){
        try{
            String update = "UPDATE videoSlide SET fps = ? WHERE id = ? ";
            PreparedStatement st = DB.prepareStatement(update);
            st.setInt(1, newFps);
            st.setInt(2, videoSlideId);
            st.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void editFormat(Integer videoSlideId, String newFormat){
        try{
            String update = "UPDATE videoSlide SET format = ? WHERE id = ? ";
            PreparedStatement st = DB.prepareStatement(update);
            st.setString(1, newFormat);
            st.setInt(2, videoSlideId);
            st.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void editPath(Integer videoSlideId, String newPath){
        try{
            String update = "UPDATE videoSlide SET path = ? WHERE id = ? ";
            PreparedStatement st = DB.prepareStatement(update);
            st.setString(1, newPath);
            st.setInt(2, videoSlideId);
            st.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
