package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("pracownicy.csv");
        Scanner sc = new Scanner(file1);
        int i =1;
        while(sc.hasNextLine())
        {
        System.out.println(i + " " +sc.nextLine());
        i++;
        }
    }
}
