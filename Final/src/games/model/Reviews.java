package games.model;

public class Reviews {
	
	private String game;
	private String rating;
	
	public Reviews() {
	}
	
	public Reviews(String game, String rating) {
		this.game = game;
		this.rating = rating;
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

	public void setReview(String rating) {
		this.rating = rating;
	}
	
	
	
}
