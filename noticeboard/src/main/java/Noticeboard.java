import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean(name="noticeboard")
@SessionScoped
public class Noticeboard {
	private List<Post> posts = new ArrayList<>();
	private int postIDCounter;
	private Date lastSeen;
	
	public Noticeboard() {
		this.postIDCounter = 1;
		this.lastSeen = new Date();
		
		// Add a dummy post
		try {
			this.addPost("Garrido", "Hello world");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addPost(String author, String text) throws IOException {
		Post post = new Post(author, text, this);
		this.posts.add(post);
		
		// Increment postID
		this.postIDCounter += 1;
		
		// Redirect to Noticeboard
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
	    externalContext.redirect("http://localhost:8080/noticeboard/noticeboard.xhtml");
	}
	
	public List<Post> getPosts() {
		for (Post post : this.posts) {
			
			// If the post is created before the last time the board was viewed
			if (post.getDate().compareTo(this.lastSeen) < 0) {
				post.setNew_post(false);
				System.out.println("False");
			} else {
				System.out.println("True");
			}
		}
		
		// Update last seen
		this.lastSeen = new Date();
		
		return this.posts;
	}
	
	public int getPostIDCounter() {
		return this.postIDCounter;
	}
}