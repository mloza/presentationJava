package pl.edu.pk.wieik.pwj.presentation.model;

import pl.edu.pk.wieik.pwj.presentation.libs.ModelInt;

import java.sql.PreparedStatement;
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
    SlideExtend extend;
    String description;

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

    public SlideExtend getExtend() {
        return extend;
    }

    public void setExtend(SlideExtend extend) {
        this.extend = extend;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected Slide() {}

    public static Slide factory() {
        return new Slide();
    }

    public Slide get(Integer id) {
        try {
            ps("SELECT s.id, s.duration, s.position, s.type, s.description, h.id as `h:id`, h.content as `h:content`, i.id as `i:id`, i.width as `i:width`, i.height as `i:height`, i.path as `i:path`, v.id as `v:id`, v.name as `v:name`, v.fps as `v:fps`, v.format as `v:format`, v.path as `v:path` FROM `slide` as s LEFT JOIN htmlSlide h on s.id = h.slide_id LEFT JOIN imageSlide i on s.id = i.slide_id LEFT JOIN videoSlide v on s.id = v.slide_id WHERE s.id = ? LIMIT 1").set(id).execute();
            res.next();

            load(res);

            if(this.type == SlideType.HTML) {
                this.extend = new HtmlSlide();
            } else if(this.type == SlideType.IMAGE) {
                this.extend = new ImageSlide();
            } else if(this.type == SlideType.VIDEO) {
                this.extend = new VideoSlide();
            }

            this.extend.load(res);

            return this;

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
    
    public Slide getByPosition(Integer presentationID, Integer slidePos) {
        try {
            ps("SELECT s.id, s.duration, s.position, s.type, s.description, h.id as `h:id`, h.content as `h:content`, i.id as `i:id`, i.width as `i:width`, i.height as `i:height`, i.path as `i:path`, v.id as `v:id`, v.name as `v:name`, v.fps as `v:fps`, v.format as `v:format`, v.path as `v:path` FROM `slide` as s LEFT JOIN htmlSlide h on s.id = h.slide_id LEFT JOIN imageSlide i on s.id = i.slide_id LEFT JOIN videoSlide v on s.id = v.slide_id  WHERE s.position = ? AND presentation_id= ? LIMIT 1").set(slidePos).set(presentationID).execute();
            res.next();

            load(res);

            if(this.type == SlideType.HTML) {
                this.extend = new HtmlSlide();
            } else if(this.type == SlideType.IMAGE) {
                this.extend = new ImageSlide();
            } else if(this.type == SlideType.VIDEO) {
                this.extend = new VideoSlide();
            }

            this.extend.load(res);

            return this;

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
    
    
    public Slide update(Integer slideID, String description, Integer duration) {
        try {
            ps("UPDATE slide SET description = ?, duration = ? WHERE id = ?");
            ps.setString(1, description);
            ps.setInt(2, duration);
            ps.setInt(3, slideID);
            ps.execute();
            //res.next();

            load(res);

            if(this.type == SlideType.HTML) {
                this.extend = new HtmlSlide();
            } else if(this.type == SlideType.IMAGE) {
                this.extend = new ImageSlide();
            } else if(this.type == SlideType.VIDEO) {
                this.extend = new VideoSlide();
            }

            this.extend.load(res);

            return this;

        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
    
    

    public List<Slide> getAll(Integer id) {
        List<Slide> list = new ArrayList<Slide>();
        try {
            for(Slide i: (Slide)ps("SELECT s.id, s.duration, s.position, s.type, s.description, h.id as `h:id`, h.content as `h:content`, i.id as `i:id`, i.width as `i:width`, i.height as `i:height`, i.path as `i:path`, v.id as `v:id`, v.name as `v:name`, v.fps as `v:fps`, v.format as `v:format`, v.path as `v:path` FROM `slide` as s LEFT JOIN htmlSlide h on s.id = h.slide_id LEFT JOIN imageSlide i on s.id = i.slide_id LEFT JOIN videoSlide v on s.id = v.slide_id WHERE presentation_id = ?").set(id).execute()) {
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
        this.id = res.getInt("id");
        this.duration = res.getInt("duration");
        this.position = res.getInt("position");
        this.type = SlideType.getByNumber(res.getInt("type"));
        this.description = res.getString("description");

        if(this.type == SlideType.HTML) {
            this.extend = new HtmlSlide();
        } else if(this.type == SlideType.IMAGE) {
            this.extend = new ImageSlide();
        } else if(this.type == SlideType.VIDEO) {
            this.extend = new VideoSlide();
        }

        this.extend.load(res);

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
    
    public void editDuration(Integer slideId, String newDuration){
		try{
			String update = "UPDATE slide SET duration = ? WHERE id = ? ";
			PreparedStatement st = DB.prepareStatement(update);
			st.setString(1, newDuration);
			st.setInt(2, slideId);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
    
    public void editPosition(Integer slideId, String newPosition){
		try{
			String update = "UPDATE slide SET position = ? WHERE id = ? ";
			PreparedStatement st = DB.prepareStatement(update);
			st.setString(1, newPosition);
			st.setInt(2, slideId);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
    
    public void editDescription(Integer slideID, String newDescription){
        try{
            String update = "UPDATE slide SET description = ? WHERE id = ? ";
            PreparedStatement st = DB.prepareStatement(update);
            st.setString(1, newDescription);
            st.setInt(2, slideID);
            st.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    
    public void removeSlide(Integer presentationId){
    	
    	//List<Slide> slideList = getAll(presentationId);
    
    	try {
			DB.prepareStatement("DELETE FROM slide where id = "+this.getId()).execute();
			 PreparedStatement st = DB.prepareStatement("SELECT max(position) from slide where presentation_id = ?");
			 PreparedStatement up = DB.prepareStatement( "UPDATE slide SET position = ? WHERE position = ?");
			 
			st.setInt(1, presentationId);
			ResultSet maxPos = st.executeQuery();
			System.out.println(maxPos.first());
			
			for(int i = this.getPosition();  i < maxPos.getInt(1); i++) {
				//DB.prepareStatement( "UPDATE slide SET position = "+(i)+" WHERE position = "+(i+1)).execute();
				up.setInt(1, i);
				up.setInt(2, i+1);
				up.execute();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    }
    
    
    
    
}
