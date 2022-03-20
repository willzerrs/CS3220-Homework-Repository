package cs3220.model;

public class Homework1Entry {

	static int idSeed = 1;
	private int id;
	
	private String title;
	private String subtitle;
	private String content;
	private String dateSubmit;
	private String datePublish;
	private boolean isPublished;
	
	public Homework1Entry(String title, String subtitle, String content, String dateSubmit, String datePublish, boolean isPublished) {
		this.id = idSeed++;
		this.title = title;
		this.subtitle = subtitle;
		this.content = content;
		this.dateSubmit = dateSubmit;
		this.datePublish = datePublish;
		this.isPublished = isPublished;
	}
	
	public boolean isPublished() {
		return isPublished;
	}

	public void setPublished(boolean isPublished) {
		this.isPublished = isPublished;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public String getDateSubmit() {
		return dateSubmit;
	}

	public void setDateSubmit(String dateSubmit) {
		this.dateSubmit = dateSubmit;
	}

	public String getDatePublish() {
		return datePublish;
	}

	public void setDatePublish(String datePublish) {
		this.datePublish = datePublish;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}



}
