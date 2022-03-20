package lab9.model;

import java.util.ArrayList;
import java.util.List;

public class ClassModel{
	
	static int idSeed = 1;
	private int id;
	private String className;
	private List<MeetingsModel> zoomLinks = new ArrayList<MeetingsModel>();
	
	public ClassModel(String className) {
		this.id = idSeed++;
		this.className = className;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public List<MeetingsModel> getZoomLinks() {
		return zoomLinks;
	}

	public void setZoomLinks(List<MeetingsModel> zoomLinks) {
		this.zoomLinks = zoomLinks;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
