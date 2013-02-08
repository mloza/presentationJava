package pl.edu.pk.wieik.pwj.presentation.model;

import pl.edu.pk.wieik.pwj.presentation.libs.Database;
import pl.edu.pk.wieik.pwj.presentation.libs.ModelInt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: scroot
 * Date: 06.02.13
 * Time: 14:20
 * To change this template use File | Settings | File Templates.
 */
public class Model<T extends ModelInt> implements Iterable<T>, Iterator<T>, ModelInt {
    protected Connection DB = Database.instance().getConn();
    protected Integer counter = 1;
    protected PreparedStatement ps;
    protected ResultSet res;
    protected String className = getClassName();

    protected String getClassName() {
        System.out.println(this.getClass().getName());
        return this.getClass().getName();
    }

    protected Model ps(String query) throws SQLException {
        ps = DB.prepareStatement(query);
        return this;
    }

    protected Model set(String val) throws SQLException {
        ps.setString(counter++, val);
        return this;
    }

    protected Model set(Integer val) throws SQLException {
        ps.setInt(counter++, val);
        return this;
    }

    protected Model execute() throws SQLException {
        res = ps.executeQuery();
        return this;
    }

    protected Model update() throws SQLException {
        ps.executeUpdate();
        return this;
    }

    public ModelInt get(Integer id) {
        try {
            ps("SELECT * FROM "+this.getClass().getSimpleName().toLowerCase()+" WHERE id = ? LIMIT 1").set(id).execute();
            res.next();

            load(res);
            return this;

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    public List<Model> getAll() {
        List<Model> list = new ArrayList<Model>();
        try {
            for(Object i: ps("SELECT * FROM "+this.getClass().getSimpleName().toLowerCase()).execute()) {
                list.add((Model)i);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        try {
            return res.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public T next() {
        try {
            T p = (T)Class.forName(className).newInstance();
            p.load(res);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ModelInt load(ResultSet res) throws SQLException {
        throw new UnsupportedOperationException();
    }
}
