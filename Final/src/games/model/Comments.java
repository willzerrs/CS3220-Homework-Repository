package games.model;

public class Comments {
	private String username;
	private String game;
	private String rating;
	private String comments;
	
	public Comments() {
	}
	
	public Comments(String username, String game, String rating, String comments) {
		this.username = username;
		this.game = game;
		this.rating = rating;
		this.comments = comments;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
