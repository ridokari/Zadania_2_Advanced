package com.company;

import javax.swing.*;
import java.io.File;
import java.text.Collator;
import java.util.*;

public class PanTaduesz {
    private static Scanner sc;

    // function for opening file
    private static void openFile() {

        JButton open = new JButton();
        JFileChooser f = new JFileChooser(".");
        f.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        if (f.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {

        }

        System.out.println(f.getSelectedFile().getAbsolutePath());
        try {
            sc = new Scanner(new File(f.getSelectedFile().getAbsolutePath()));
        } catch (Exception e) {
            System.out.println("not found");
        }

    }

    //function for closing Scanner
    private static void closeFile() {
        sc.close();
    }

    // function to print whole file word by word
    private static void PrintFile() {
        int i = 0;
        int j = 0;
        String wyraz = JOptionPane.showInputDialog("Wybierz wyraz");

        while (sc.hasNext()) {

            sc.useDelimiter("[-+*, …—?»)(«!.;:/#_^\\s]+");
            // I have a problem here with delimiter as it adds empty strings as words
            // PC: add + at the end, which means: "one or more" (consecutive sign makes a single delimiter...)
            String slowo = sc.next();
            // I was forced to add this function because of delimiter problem
            if (!slowo.equals("")) {
                j++;
            }
            if (slowo.equals(wyraz)) {
                i++;
            }
        }
        System.out.println("tadeusz = " + i);
        System.out.println("slowa = " + j);
    }

    //
    public static void Zadanie_3_2() {
        System.out.println("wczytaj plik Pan Tadeusz.txt");

        openFile();
        PrintFile();
        closeFile();
    }

    // function that adds every word in file to list to make any further operations easier
    private static void TxtToList(List<String> words) {
        String slowo;
        while (sc.hasNext()) {
            // I have a problem here with delimiter as it adds empty strings as words
            sc.useDelimiter("[-+*, .…—?»)(«!;:/#_^\\s]+");
            slowo = sc.next();
            // I was forced to add this function because of delimiter problem:
            if (!slowo.equals("")) {
                words.add(slowo);
            }
        }
    }

    // function to create a list of unique only words in file
    private static List<String> getStrings(List<String> words) {
        List<String> words2 = new ArrayList<>();

        for (String temp : words) {

            if (!words2.contains(temp)) {
                words2.add(temp);
            }
        }
        return words2;
    }

    private static void Zadanie_3_3_No_sort(){
        System.out.println("wczytaj plik Pan Tadeusz.txt");
        openFile();
        List<String> words = new ArrayList<>();
        TxtToList(words);
        List<String> words2 = getStrings(words);

        for (String temp:words2){
            int occurrences = Collections.frequency(words, temp);
            System.out.println(temp +" = "+occurrences );
        }
        closeFile();
    }

    private static void Zadanie_3_3_alphabetical(){
        System.out.println("wczytaj plik Pan Tadeusz.txt");
        openFile();
        List<String> words = new ArrayList<>();
        TxtToList(words);
        List<String> words2 = getStrings(words);
        words2.sort(Collator.getInstance(new Locale("pl", "PL")));
        for (String temp:words2){
            int occurrences = Collections.frequency(words, temp);
            System.out.println(temp +" = "+occurrences );
        }
        closeFile();
    }

    private static void Zadanie_3_3_numerical(){
        System.out.println("wczytaj plik Pan Tadeusz.txt");
        openFile();
        List<String> words = new ArrayList<>();
        TxtToList(words);
        List<String> words2 = getStrings(words);
        words2.sort(Collator.getInstance(new Locale("pl", "PL")));
        List<Words> word = new ArrayList<>();
        for (String temp2 : words2) {
            int occurrences = Collections.frequency(words, temp2);
            word.add(new Words(temp2, occurrences));
        }
        word.stream()
              .sorted(Comparator.comparingInt(Words::getNumber).reversed())
              .forEach(System.out::println);
        closeFile();
    }

    private static void Zadanie_3_5(){
        System.out.println("wczytaj plik polimorf");
    openFile();
    HashMap <String,String> map = new HashMap<>();
    while(sc.hasNextLine()) {
        String linia = sc.nextLine();
        String[] fragmenty = linia.split("\\t");
        map.put(fragmenty[0].toLowerCase(), fragmenty[1]);
    }
        System.out.println("wczytaj plik Pan Tadeusz.txt");
        openFile();
        List<String> words = new ArrayList<>();
        String slowo;
        int j =0;
        while (sc.hasNext()) {
            sc.useDelimiter("[-+*, .…—?»)(«!;:/#_^\\s]+");
            slowo = sc.next();
            if (!slowo.equals("")) {
                if(map.get(slowo.toLowerCase())==null){
                    words.add(slowo);
                }else{
                    words.add(map.get(slowo.toLowerCase()));
                }
            }
        }
        TxtToList(words);
        List<String> words2 = getStrings(words);
        for (String temp:words2){
            int occurrences = Collections.frequency(words, temp);
            System.out.println(temp +" = "+occurrences );
        }
        closeFile();
    }

    private static void Zadanie_3_4() {
        // tu nie do końca wiem czy o to chodziło w zadaniu czy stworzeniu jakiejś biblioteki
        System.out.println("wczytaj plik polimorf");
        openFile();
        List<Polimorf> baza = new ArrayList<>();
        while(sc.hasNextLine()) {
            String linia = sc.nextLine();
            String[] fragmenty = linia.split("\\t");
            Polimorf temp = new Polimorf(fragmenty[0],fragmenty[1]);
            baza.add(temp);
        }
            String wyraz;
            wyraz =JOptionPane.showInputDialog("Wybierz wyraz");
        System.out.println(wyraz);
            while(wyraz!=null){
            boolean found = false;
            for (Polimorf temp : baza) {
                if (wyraz.equals(temp.getPodst())) {
                    System.out.println("forma podstawowa: " + wyraz + " - odmieniona: " + temp.getOdmiana());
                    found = true;
                }
                if (wyraz.equals(temp.getOdmiana())) {
                    System.out.println("forma odmieniona: " + wyraz + " - podstawowa: " + temp.getPodst());
                    found = true;
                }
            }
            if (!found){
            System.out.println("nie znaleziono");
        }
            found = false;
            wyraz =JOptionPane.showInputDialog("Wybierz wyraz");
        }
    }




    public static void main(String[] args) {
      // Zadanie_3_2();
      // Zadanie_3_3_No_sort();
      // Zadanie_3_3_alphabetical();
      // Zadanie_3_3_numerical();
      // Zadanie_3_4();
      Zadanie_3_5();



    }
}
