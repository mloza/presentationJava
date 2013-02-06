package pl.edu.pk.wieik.pwj.presentation.model;

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
    protected String description;
    protected String content;

    @Override
    protected SlideExtend load(ResultSet res) throws SQLException {
        this.id = res.getInt("h:id");
        this.description = res.getString("h:description");
        this.content = res.getString("h:content");
        return this;
    }
}
