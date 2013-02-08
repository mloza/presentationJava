package pl.edu.pk.wieik.pwj.presentation.model;
import pl.edu.pk.wieik.pwj.presentation.libs.Database;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import pl.edu.pk.wieik.pwj.presentation.libs.ModelInt;

public class News extends Model<News> implements ModelInt {

	protected Integer id;
	protected String  content;
	protected Date date;
	protected Integer position;
	
	// TODO Konstruktor tylko do testów
	public News(Integer id, String content, Date date, Integer position) {
		this.id = id;
		this.content = content;
		this.date = date;
		this.position = position;
	}
	
	protected News() { };
	
	  public static News factory() {
	        return new News();
	    }
	    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}
	
	

	@Override
	public ModelInt load(ResultSet res) throws SQLException {
		this.id = res.getInt(1);
        this.content = res.getString(2);
        this.date = res.getDate(3);
        this.position = res.getInt(4);
        return this;

	}
	
	public void save(){
		
		try {
			String insert = "INSERT INTO news (content, data, position) values (?, ?, ?) ";
			java.sql.PreparedStatement st = DB.prepareStatement(insert);
			st.setString(1, this.getContent());
			st.setDate(2, this.getDate());
			st.setInt(3, this.getPosition());
			st.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	}
	
	public void editContent(Integer newsId, String newContent){
		try{
			String update = "UPDATE news SET content = ? WHERE id = ? ";
			PreparedStatement st = DB.prepareStatement(update);
			st.setString(1, newContent);
			st.setInt(2, newsId);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public void editPosition(Integer newsId, String newPosition){
		try{
			String update = "UPDATE news SET position = ? WHERE id = ? ";
			PreparedStatement st = DB.prepareStatement(update);
			st.setString(1, newPosition);
			st.setInt(2, newsId);
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
