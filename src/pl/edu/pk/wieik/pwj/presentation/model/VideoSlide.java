package pl.edu.pk.wieik.pwj.presentation.model;

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
    protected String description;
    protected Integer fps;
    protected String format;
    protected String path;

    @Override
    protected SlideExtend load(ResultSet res) throws SQLException {
        this.id = res.getInt("v:id");
        this.description = res.getString("v:name");
        this.description = res.getString("v:description");
        this.path = res.getString("v:path");
        this.fps = res.getInt("v:fps");
        this.format = res.getString("v:format");
        return this;
    }
}
