package it.xpug.birthday_greetings;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.dumbster.smtp.SimpleSmtpServer;

public class SmtpMailService implements IEmailService {

	int port;
	String host;
	Message msg;
	Session session;
	
	public SmtpMailService(String host, int port){
		this.host = host;
		this.port = port;
	}

	public void send(Greetings greetings) throws AddressException, MessagingException {
		
		createMailSession();
		constructMessage(greetings);
		
		Transport.send(msg);
		System.out.println("Sent message successfully....");
	}

	public void createMailSession() {
		java.util.Properties props = new java.util.Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "" + port);
		session = Session.getInstance(props, null);
		
	}

	public void constructMessage(Greetings greetings) throws AddressException, MessagingException {
		
		msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(greetings.getDestinationEmail()));
		System.out.println("--------------------" + greetings.getDestinationEmail());
		msg.setRecipient(Message.RecipientType.TO, new InternetAddress(greetings.getOriginEmail()));
		System.out.println("--------------------" + greetings.getOriginEmail());
		msg.setSubject(greetings.getSubject());
		System.out.println("--------------------" + greetings.getSubject());
		msg.setText(greetings.getMessage());
		System.out.println("--------------------" + greetings.getMessage());
		msg.saveChanges();
        
	}
	
}
