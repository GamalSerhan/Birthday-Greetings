package it.xpug.birthday_greetings;
import java.util.ArrayList;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class BirthdayService {

	private IEmployeeRepository repository;
	private IEmailService messageService;
	
	public BirthdayService(IEmployeeRepository repository,IEmailService messageService) {
		this.repository = repository;
		this.messageService = messageService;
	}
	
	public void sendGreetings(XDate date) throws AddressException, MessagingException {
		ArrayList<Employee> employees = repository.getEmployeesBirthday(date);
		
		for (Employee employee : employees) {
			Greetings greetings = new Greetings(employee);
			messageService.send(greetings);
		}
	}

}
