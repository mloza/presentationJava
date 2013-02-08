package pl.edu.pk.wieik.pwj.presentation.model;

import pl.edu.pk.wieik.pwj.presentation.libs.Database;
import pl.edu.pk.wieik.pwj.presentation.libs.ModelInt;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

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
    
    /*public List<Presentation> getAll() {
      
    	List<Presentation> presentations = new ArrayList<Presentation>();
        
      
        try {
        	
        	ResultSet prs = DB.prepareStatement("SELECT * FROM presentation").executeQuery();
        	prs.first();
        	while(!prs.isAfterLast()){
        		Presentation temp = Presentation.factory();
        		int presId = prs.getInt(1);
        		String id = "Select id FROM presentation where id = " + presId;
        		String name = "Select name FROM presentation where id = " + presId;
        		
        		java.sql.PreparedStatement prepId = DB.prepareStatement(id);
        		java.sql.PreparedStatement prepName = DB.prepareStatement(name);
        		
        		ResultSet rId = prepId.executeQuery();
        		rId.first();
        		ResultSet rName = prepName.executeQuery();
        		rName.first();
        		
        		temp.setId(rId.getInt(1));
        		temp.setName(rName.getString(1));
        		System.out.println(temp.getId());
        		System.out.println(temp.getName());
        		presentations.add(temp);
        		prs.next();
        	}
        	for (Presentation p : presentations){
        		List<Slide> list = new ArrayList<Slide>(); //slajdy danej prezentacji
        		ResultSet prsS = DB.prepareStatement("SELECT * FROM slide where presentation_id =" + p.getId()).executeQuery();
            	prsS.first();
            	
            	while(prsS.isAfterLast()){
            		Slide tempS = Slide.factory();
            		int slideId = prs.getInt(1);
            		System.out.println(slideId);
            		Integer id = prsS.getInt(1);
            		Integer duration = prsS.getInt(3);
            		Integer position = prsS.getInt(4);
            		Integer type = prsS.getInt(5);
            		
            		tempS.setId(id);
            		tempS.setDuration(duration);
            		tempS.setPosition(position);
            		tempS.setType(SlideType.getByNumber(type));
            		list.add(tempS);
            		//System.out.println((Presentation)ps("Select * FROM presentation where id = " + presId));
            		prsS.next();
        	       	
            }
            	p.getSlides().addAll(list);
        	}
        	
        	return presentations;
           
            //return list;
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
       return presentations;
    }*/
    
        
    //artx - zapisanie calej prezentacji ze slajdami (cos mi insert nie dizala 
    public void save(){
    	try {
    		ps("INSERT INTO presentation(name) values (?) ").set(name).update();
    		String insert = "INSERT INTO slide (presentation_id, duration, position, type) values (?, ?, ?, ?) ";
			String select = "SELECT ID FROM presentation WHERE name = (?) LIMIT 1"; 
			java.sql.PreparedStatement st = DB.prepareStatement(insert);
			java.sql.PreparedStatement stS = DB.prepareStatement(select);
			stS.setString(1, this.getName());
			ResultSet idP =  stS.executeQuery();
			idP.first(); //ustawiam kursor na pierwszym(jedynym w zasadzie wyniku)
			int presentation_id = idP.getInt(1); //biore sobie id
			
    		for(Slide slide : slides){
    			if(slide.getType() == SlideType.HTML)
    			{	
    				st.setInt(1, presentation_id); //zapsiuje z id danej prezentacji
    				st.setInt(2, slide.getDuration());
    				st.setInt(3, slide.getPosition());
    				st.setInt(4, slide.getType().ordinal());
    				st.execute();
	    			}
    			
	    		if(slide.getType() == SlideType.IMAGE){
	    		
    				st.setInt(1, presentation_id); //zapsiuje z id danej prezentacji
    				st.setInt(2, slide.getDuration());
    				st.setInt(3, slide.getPosition());
    				st.setInt(4, slide.getType().ordinal());
    				st.execute();
    				}
	    		
    			if(slide.getType() == SlideType.VIDEO){
    			
    				st.setInt(1, presentation_id); //zapsiuje z id danej prezentacji
    				st.setInt(2, slide.getDuration());
    				st.setInt(3, slide.getPosition());
    				st.setInt(4, slide.getType().ordinal());
    				st.execute();
    			}
    		}
    		
    	}
    	catch(SQLException e){
    	  e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
    }
}
