package lab9.model;

public class MeetingsModel{
	
	static int idSeed = 1;
	private int id;
	private String sectionName;
	private String zoomLink;
	public MeetingsModel(String sectionName, String zoomLink) {
		this.id = idSeed++;
		this.sectionName = sectionName;
		this.zoomLink = zoomLink;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getZoomLink() {
		return zoomLink;
	}
	public void setZoomLink(String zoomLink) {
		this.zoomLink = zoomLink;
	}
	
	

}
