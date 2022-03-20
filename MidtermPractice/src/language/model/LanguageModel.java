package language.model;

public class LanguageModel{
	
	static int idSeed = 1;
	private int id;
	private String languageName;
	private int responseCounter;
    
    public LanguageModel(String languageName, int responseCounter) {
    	this.id = idSeed++;
        this.languageName = languageName;
        this.responseCounter = responseCounter;
    }

    public int getId() {
		return id;
	}
    
	public void setId(int id) {
		this.id = id;
	}
    
	public String getLanguageName() {
		return languageName;
	}

	public void setLanguage(String languageName) {
		this.languageName = languageName;
	}

	public int getResponseCounter() {
		return responseCounter;
	}

	public void setResponseCounter(int responseCounter) {
		this.responseCounter = responseCounter;
	}
    
    

	
}
