package it.xpug.birthday_greetings;

public class Greetings {
	private String originEmail;
	private String destinationEmail;
	private String subject;
	private String message;
	
	public Greetings (Employee employee) {
		initializeData(employee);
	}
	
	public void initializeData (Employee employee) {
		initializeOriginEmail(employee);
		initializeDestinationEmail();
		initializeSubject();
		initializeMessage(employee);
	}
	
	public void initializeDestinationEmail () {
		this.destinationEmail = "sender@here.com";
	}
	
	public void initializeOriginEmail (Employee employee) {
		this.originEmail = employee.getEmail();
	}
	
	public void initializeSubject () {
		this.subject = "Happy Birthday!";
	}
	
	public void initializeMessage (Employee employee) {
		this.message = "Happy Birthday, dear %NAME%".replace("%NAME%", employee.getFirstName());
	}
	
	
	public String getDestinationEmail () {
		 return this.destinationEmail;
	}
	
	public String getOriginEmail () {
		 return this.originEmail;
	}
	
	public String getSubject () {
		 return this.subject;
	}
	
	public String getMessage () {
		 return this.message;
	}
	
}
