package pl.edu.pk.wieik.pwj.presentation.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: scroot
 * Date: 06.02.13
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
public class HtmlSlide extends SlideExtend {
    protected Integer id;
    protected String content;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public SlideExtend load(ResultSet res) throws SQLException {
        this.id = res.getInt("h:id");
        this.content = res.getString("h:content");
        return this;
    }

    public void save(){
        try {
            String insert = "INSERT INTO htmlSlide (content) values (?) ";
            java.sql.PreparedStatement st = DB.prepareStatement(insert);
            st.setString(1, this.getContent());
            st.execute();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void editContent(Integer htmlSlideId, String newContent){
        try{
            String update = "UPDATE htmlSlide SET content = ? WHERE id = ? ";
            PreparedStatement st = DB.prepareStatement(update);
            st.setString(1, newContent);
            st.setInt(2, htmlSlideId);
            st.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
