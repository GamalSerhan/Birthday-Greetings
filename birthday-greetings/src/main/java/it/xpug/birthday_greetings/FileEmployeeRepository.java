package it.xpug.birthday_greetings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import com.sun.tools.javac.util.List;


public class FileEmployeeRepository implements IEmployeeRepository {
	
	ArrayList <Employee> employees2  = new ArrayList<Employee>();
	private String file;

	public FileEmployeeRepository(String file) throws ParseException, IOException{
		this.file = file;
		uploadEmployeeData();
	}

	public void uploadEmployeeData() throws ParseException, IOException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		String str = "";
		str = in.readLine(); // skip header
		while ((str = in.readLine()) != null) {
			String[] employeeData = str.split(", ");
			Employee employee = new Employee(employeeData[1], employeeData[0], employeeData[2], employeeData[3]);
			employees2.add(employee);
		}
	}

	
	public ArrayList<Employee> getEmployeesBirthday(XDate date) {
		ArrayList <Employee> employeesBirthday  = new ArrayList<Employee>();
		for (Employee employee : employees2) {
			if (employee.isBirthday(date)) {
				employeesBirthday.add(employee);
			}
		}
		return employeesBirthday;
	}

}
