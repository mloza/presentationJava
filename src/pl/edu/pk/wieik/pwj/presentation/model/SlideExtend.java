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
public abstract class SlideExtend extends Model {
    protected abstract SlideExtend load(ResultSet res) throws SQLException;
}
