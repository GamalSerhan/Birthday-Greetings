package it.xpug.birthday_greetings;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import com.sun.tools.javac.util.List;

public interface IEmployeeRepository {
		
	public void uploadEmployeeData() throws ParseException, FileNotFoundException, IOException;
	public ArrayList<Employee> getEmployeesBirthday(XDate date);
}
