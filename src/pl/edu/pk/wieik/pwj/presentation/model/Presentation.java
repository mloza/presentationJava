package pl.edu.pk.wieik.pwj.presentation.model;

import pl.edu.pk.wieik.pwj.presentation.libs.ModelInt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: scroot
 * Date: 06.02.13
 * Time: 14:06
 * To change this template use File | Settings | File Templates.
 */
public class Presentation extends Model<Presentation> implements ModelInt {

    protected Integer id;
    protected String name;
    private List<Slide> slides;

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

    protected Presentation() { }

    protected Presentation(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Presentation factory() {
        return new Presentation();
    }

    public Presentation get(Integer id) {
        try {
            ps("SELECT * FROM `presentation` WHERE id = ? LIMIT 1").set(id).execute();
            res.next();

            load(res);
            return this;

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    @Override
    public ModelInt load(ResultSet res) throws SQLException {
        this.id = res.getInt(1);
        this.name = res.getString(2);
        return this;
    }

    public List<Slide> getSlides() {
        slides = Slide.factory().getAll(this.id);
        return slides;
    }
    //artix
    public void save(){
    	try{
    		//INSERT INTO presentation values (2,'prezentacja2')
    		ps("INSERT INTO presentation(name) values (?) ").set(name).execute();
    		
    		}
    	catch(SQLException e){
    		  e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    	}
    }
}
