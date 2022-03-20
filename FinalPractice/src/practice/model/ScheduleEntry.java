package practice.model;

public class ScheduleEntry {
	
	private String time;
	private String day;
	private String name;
	
	public ScheduleEntry() {
		
	}
	
	public ScheduleEntry(String time, String day, String name) {
		this.time = time;
		this.day = day;
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
