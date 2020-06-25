import java.util.Date;
import javax.faces.bean.ManagedBean;


@ManagedBean(name="post")
public class Post {
	private int id;
	private String author;
	private String text;
	private Date date;
	private boolean new_post;
	
	public Post() {
		
	}
	
	public Post(String author, String text, Noticeboard noticeboard) {
		this.id = noticeboard.getPostIDCounter();
		this.author = author;
		this.text = text;
		this.date = new Date();
		this.new_post = true;
	}
	
	public int getId() {
		return id;
	}

	public String getAuthor() {
		return this.author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Date getDate() {
		return date;
	}

	public boolean isNew_post() {
		return new_post;
	}

	public void setNew_post(boolean new_post) {
		this.new_post = new_post;
	}

	// For debugging
	public String toString() {
		return "Author: " + this.author + "\t Text: " + this.text + "\n";
	}
}