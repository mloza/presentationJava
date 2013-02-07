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
public class ImageSlide extends SlideExtend {
    protected Integer id;
    protected String description;
    protected Integer width;
    protected Integer height;
    protected String path;

    @Override
    protected SlideExtend load(ResultSet res) throws SQLException {
        this.id = res.getInt("i:id");
        this.description = res.getString("i:description");
        this.path = res.getString("i:path");
        this.width = res.getInt("i:width");
        this.height = res.getInt("i:height");
        return this;
    }
}
