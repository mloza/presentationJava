package pl.edu.pk.wieik.pwj.presentation.model;

import pl.edu.pk.wieik.pwj.presentation.libs.ModelInt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: scroot
 * Date: 06.02.13
 * Time: 15:18
 * To change this template use File | Settings | File Templates.
 */
public class Slide extends Model<Slide> implements ModelInt {
    Integer id;
    Integer duration;
    Integer position;
    SlideType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public SlideType getType() {
        return type;
    }

    public void setType(SlideType type) {
        this.type = type;
    }

    protected Slide() {}

    public static Slide factory() {
        return new Slide();
    }

    public Slide get(Integer id) {
        try {
            ps("SELECT * FROM `slide` WHERE id = ? LIMIT 1").set(id).execute();
            res.next();

            load(res);
            return this;

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    public List<Slide> getAll(Integer id) {
        List<Slide> list = new ArrayList<Slide>();
        try {
            for(Slide i: (Slide)ps("SELECT * FROM `slide` WHERE presentation_id = ?").set(id).execute()) {
                list.add(i);
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public Slide load(ResultSet res) throws SQLException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
