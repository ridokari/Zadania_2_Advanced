package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObslugaCSV {
	
	public static List<Employee> wczytaj(String sciezka) {
		File plik = new File(sciezka);
		return wczytaj(plik);
	}
	
	public static List<Employee> wczytaj(File plik) {
		List<Employee> lista = new ArrayList<>();

		try(Scanner sc = new Scanner(plik)) {
			while(sc.hasNextLine()) {
				String linia = sc.nextLine();
				String[] fragmenty = linia.split(";", 11);

				int id = Integer.parseInt(fragmenty[0]);
				int salary = Integer.parseInt(fragmenty[4]);
				LocalDate hireDate = LocalDate.parse(fragmenty[5]);

				Employee emp = new Employee(id, fragmenty[1], fragmenty[2], fragmenty[3], salary, hireDate,
						fragmenty[6], fragmenty[7], fragmenty[8], fragmenty[9], fragmenty[10]);

				lista.add(emp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

	public static void zapisz(List<Employee>update) throws FileNotFoundException {
		List<Employee> lista = new ArrayList<>();
		String filename = JOptionPane.showInputDialog("name a file");
		PrintWriter pc = new PrintWriter(filename+".csv");
		for (Employee temp:update) {
			pc.println(temp);
		}
		pc.close();
	}


}
