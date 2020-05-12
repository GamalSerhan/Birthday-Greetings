package it.xpug.birthday_greetings;

import java.io.*;
import java.text.ParseException;

import javax.mail.*;
import javax.mail.internet.*;

	public class Main {

		public static void main(String[] args) throws AddressException, IOException, ParseException, MessagingException {
			EmployeeRepository repository = new FileEmployeeRepository("employee_data.txt");
			EmailService emailService = new smtpMailService("localhost", 25);
			BirthdayService service = new BirthdayService(repository, emailService);
			service.sendGreetings(OurDate.today());
		}
}
