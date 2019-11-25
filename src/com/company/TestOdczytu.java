package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class TestOdczytu {
	// loop for raising Employee salary
	private static void EditByLoop(String jobTitle, int Raise, List<Employee> employees, PrintWriter x) {
		for (Employee emp : employees) {
			if (emp.getJobTitle().equals(jobTitle)) {
				emp.setSalary(emp.getSalary() + Raise);
			}
			x.println(emp);

		}
		x.close();
	}

	//Stream for raising Employee salary
	private static void EditByStream(String jobTitle, int raise, List<Employee> employees, PrintWriter x) {
		employees.stream()
				.filter(emp -> emp.getJobTitle().equals(jobTitle))
				.forEach(emp -> emp.setSalary(emp.getSalary() + raise));

		employees.forEach(x::println);
	}

	// This block of code takes data from one file and after conversion save it to another
	private static void Zadanie_3_1_Loop() throws FileNotFoundException {
	String output = JOptionPane.showInputDialog("please provide output file name") + ".csv";
	String JobTitle = JOptionPane.showInputDialog("please provide Job title");
	int Raise = Integer.parseInt(JOptionPane.showInputDialog("please provide raise amount"));
	File plik = new File("pracownicy.csv");
	List<Employee> employees = ObslugaCSV.wczytaj(plik);
	System.out.println("Wczytano "+employees.size()+" rekordów");
	File file2 = new File(output);
	PrintWriter x = new PrintWriter(file2);
	EditByLoop(JobTitle, Raise, employees, x);
}
	// This block of code takes data from one file and after conversion save it to another
	// unfortunately i was unable to refactor more of it to avoid duplication of code
	private static void Zadanie_3_1_Stream() throws FileNotFoundException {
		String output = JOptionPane.showInputDialog("please provide output file name") + ".csv";
		String JobTitle = JOptionPane.showInputDialog("please provide Job title");
		int Raise = Integer.parseInt(JOptionPane.showInputDialog("please provide raise amount"));
		File plik = new File("pracownicy.csv");
		List<Employee> employees = ObslugaCSV.wczytaj(plik);
		System.out.println("Wczytano "+employees.size()+" rekordów");
		File file2 = new File(output);
		PrintWriter x = new PrintWriter(file2);
		EditByStream(JobTitle, Raise, employees, x);
	}



	public static void main(String[] args) throws FileNotFoundException {
		// Zadanie_3_1_Loop();
		Zadanie_3_1_Stream();





	}




}
