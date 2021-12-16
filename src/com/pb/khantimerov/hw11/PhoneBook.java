package com.pb.khantimerov.hw11;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneBook {
    public static void main(String[] args) {

        Abonent abonent1 = new Abonent("Хантимеров",
                LocalDate.of(1972,3,8),
                Arrays.asList("0675555555", "0999999999", "0552325325"),
                "Херсон", LocalDateTime.of(2021,12,16,10,20));
        Abonent abonent2 = new Abonent("Чичиков",
                LocalDate.of(1977,8,3),
                Arrays.asList("0672222222", "0999999222", "0552325222"),
                "Херсон", LocalDateTime.of(2021,12,16,10,30));

        //ArrayList<Abonent> PhoneBook = new ArrayList<Abonent>;
        List<Abonent> phoneBook = new ArrayList<>();

        phoneBook.add(abonent1);
        phoneBook.add(abonent2);

        // System.out.println(abonent1);
        // System.out.println(abonent2);
        System.out.println(phoneBook.get(0));
        System.out.println(abonent2);
        phoneBook.get(1).setFio("Чичваркин");
        phoneBook.get(1).setEdited(LocalDateTime.now());
        System.out.println(abonent2);
        //System.out.println(abonent1);
        //phoneBook.set(2, null);

        //System.out.println(LocalDateTime.now());

        //System.out.println("abonent (2)" + phoneBook.get(2));

        Abonent abonent_3 = new Abonent("Third",
                LocalDate.of(1933,3,13),
                Arrays.asList("093333333333", "0993333333"), "Kherson 3",
                LocalDateTime.now());

        phoneBook.add(abonent_3);
        searchName(phoneBook,"Third");
        searchNumber(phoneBook, "0675555555");
    }

    public static void addAbonent (List<Abonent> pBook, Abonent ab) {
        pBook.add(ab);
        System.out.println("\nAbonent " + ab.getFio() + " added.");
    }

    public static void delAbonent (List<Abonent> pBook, Abonent ab) {
        pBook.remove(ab);
        System.out.println("\nAbonent " + ab.getFio() + " deleted");
    }

    public static void searchName (List<Abonent> pBook, String name) {
        for (Abonent p : pBook) {
            if (p.getFio() == name) {
                System.out.println("\nAbonent " + name + " detected. \n" + p);
            }
        }
        }

        public static void searchNumber (List<Abonent> pBook, String nr) {
            for (Abonent p : pBook) {
                //List<String> phoneNrs
                for (String n : p.getPhoneNrs()) {
                    if (n == nr) {
                    System.out.println("\nNumber " + nr + " detected at Abonent " + p.getFio() + " " + p);
                } else {

                    }
            }
        }
    }

}

