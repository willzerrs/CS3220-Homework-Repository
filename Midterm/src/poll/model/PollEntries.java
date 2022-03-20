package poll.model;

import java.util.ArrayList;
import java.util.List;

public class PollEntries{
	
	static int idSeed = 1;
	private int id;
	private String question;
	private List<String> answers = new ArrayList<String>();
	
    public PollEntries(String question) {
    	this.id = idSeed++;
        this.question = question;
    }

	public static int getIdSeed() {
		return idSeed;
	}

	public static void setIdSeed(int idSeed) {
		PollEntries.idSeed = idSeed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

}
