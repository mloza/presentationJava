package pl.edu.pk.wieik.pwj.presentation.libs;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: scroot
 * Date: 06.02.13
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
public interface ModelInt {
    public ModelInt load(ResultSet res) throws SQLException;
}
