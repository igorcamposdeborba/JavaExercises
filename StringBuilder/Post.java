package StringBuilder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	
	private List<Comment> comments = new ArrayList<Comment>(); // composição com relação 1 para muitos. 
	private static SimpleDateFormat formatDataMask = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
	
	public Post(Date moment, String title, String content, Integer likes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}
	
	// Methods of access
	public Date getMoment() {
		return moment;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public Integer getLikes() {
		return likes;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public List<Comment> getComments(){
		return comments;
	}
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	public void removeComment(Comment comment) {
		comments.remove(comment);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); // StringBuilder consome menos memória do que só concatenar
		sb.append(title + "\n");
		sb.append(likes);
		sb.append(" curtidas - ");
		sb.append(formatDataMask.format(moment) + "\n"); // formatar a data para uma mascara
		sb.append("Comentarios:" + "\n");
		
		for (Comment c : comments) { // imprimir cada comentario
			sb.append(c.getText() + "\n");
		}
		return sb.toString();
	}
	
}
