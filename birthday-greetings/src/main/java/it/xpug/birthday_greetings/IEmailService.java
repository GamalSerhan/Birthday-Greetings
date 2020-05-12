package it.xpug.birthday_greetings;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface IEmailService {

	void send(Greetings greetings) throws AddressException, MessagingException;
	void createMailSession () ;
	void constructMessage(Greetings greetings) throws AddressException, MessagingException ;
	
}
