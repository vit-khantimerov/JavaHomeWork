package com.pb.khantimerov.hw12;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Phonebook12 {
    public static void main(String[] args) throws Exception {
        File bookPath = Paths.get("src/com/pb/khantimerov/hw12/phonebook.data").toFile();

        System.out.println("*** Создаем абонентов ***");

        Abonent12 abonent1 = new Abonent12("Хантимеров",
                LocalDate.of(1972, 3, 8),
                Arrays.asList("0675555555", "0991111111", "0552325325"),
                "Херсон", LocalDateTime.of(2021, 12, 16, 10, 20));
        Abonent12 abonent2 = new Abonent12("Чичиков",
                LocalDate.of(1977, 8, 3),
                Arrays.asList("0672222222", "0999999222", "0552325325"),
                "Херсон", LocalDateTime.of(2021, 12, 16, 10, 30));
        Abonent12 abonent3 = new Abonent12("Third",
                LocalDate.of(1933,3,13),
                Arrays.asList("093333333333", "0993333333"), "Николаев",
                LocalDateTime.of(2021, 12, 17, 11, 23));
        Abonent12 abonent4 = new Abonent12("Сидоров",
                LocalDate.of(1999, 12, 18),
                Arrays.asList("067333333", "0991133311", "0552111125"),
                "Харьков", LocalDateTime.of(2021, 12, 17, 9, 55));
        Abonent12 abonent5 = new Abonent12("Исаев",
                LocalDate.of(2000, 10, 30),
                Arrays.asList("055555555", "099995555"),
                "Киев", LocalDateTime.of(2021, 12, 18, 20, 15));


        List<Abonent12> phoneBook12 = Stream.of(abonent1, abonent2, abonent3, abonent4, abonent5)
                .collect(Collectors.toList());
        System.out.println("*** Составляем телефонную книгу ***\n" + phoneBook12
                + "\n\nКоличество абонентов " + phoneBook12.size() + "."
                + "\n****************************************************");

        addAbonent(phoneBook12,abonent5);
        delAbonent(phoneBook12,phoneBook12.get(4));

        System.out.println();

        System.out.println("\nДанные абонента 2: " + phoneBook12.get(1));
        System.out.println("\nДанные абонента 3: " + abonent4);
        System.out.println("\nПорядковый номер " + phoneBook12.get(1).getFio()
                + " в списке - № " + phoneBook12.indexOf(phoneBook12.get(1)));

        System.out.println();

        System.out.println("\n----------------------------------------");
        System.out.println("Поиск по ФИО");
        searchName(phoneBook12,"Хантимеров");
        searchName(phoneBook12,"Энгельс");

        System.out.println("\nПоиск по номеру");
        searchNumber(phoneBook12, "325325"); // найден, ответ - ФИО + все номера телефонов
        searchNumber(phoneBook12,"1597533"); // не наден, ответ - пустая строка

        System.out.println("\nПоиск по всем полям"); //кроме даты редактирования
        searchAny(phoneBook12, "ов");
        System.out.println();
        searchAny(phoneBook12, "08");
        System.out.println();
        searchAny(phoneBook12, ".08.");
        System.out.println();
        searchAny(phoneBook12,"067");

        System.out.println("----------------------------------------");

        System.out.println();

        editAbonent(phoneBook12,"Third", "Авдеев");
        editAbonent(phoneBook12, "Сидоров", "Федоров");
        searchName(phoneBook12,"Third");

        editAbonentPhone(phoneBook12, "Федоров",
                Arrays.asList("77777", "88888888", "9999999", "1010101"));
        editAbonentPhone(phoneBook12,"Некто",Arrays.asList("01010101"));

        System.out.println("\n***   Отредактированная телефонная книга   ***");
        phoneBook12.stream()
                .forEach(System.out::println);


        System.out.println("\n   *** Варианты сортировки  ***");

        phoneBook12.sort(Comparator.comparing(p -> p.fio));
        System.out.println("Сортирока по фамилии.\n" + phoneBook12 + "\n");

        phoneBook12.sort(Comparator.comparing(p -> p.dateOfBirth));
        System.out.println("Сортировка по дате рождения.\n" + phoneBook12 + "\n");

        phoneBook12.sort(Comparator.comparing(p -> p.edited));
        System.out.println("Сортирока по дате и времени изменения.\n" + phoneBook12 + "\n");


// Запись и чтение телефонной книги

        FileOutputStream outputStreamBook = new FileOutputStream(bookPath);
        ObjectOutputStream objectOutputStreamBook = new ObjectOutputStream(outputStreamBook);
        objectOutputStreamBook.writeObject(phoneBook12);
        objectOutputStreamBook.close();

        File bookPath2 = Paths.get("src/com/pb/khantimerov/hw12/phonebook.data").toFile();

        FileInputStream fileInputStreamBook2 = new FileInputStream(bookPath2);
        ObjectInputStream objectInputStreamBook2 = new ObjectInputStream(fileInputStreamBook2);

        List<Abonent12> book_2 = (List<Abonent12>) objectInputStreamBook2.readObject();

        System.out.println("\n      ***********************  " +
                "\nТелефоная книга 2, класс " + book_2.get(0).getClass().getSimpleName() + ".");
        System.out.println(book_2);
        objectInputStreamBook2.close();

    } // *** END OF PSV MAIN ***


    public static void addAbonent(List<Abonent12> pBook, Abonent12 ab) {
        pBook.add(ab);
        System.out.println("\nАбонент " + ab.getFio() + " добавлен.");
    }

    public static void delAbonent(List<Abonent12> pBook, Abonent12 ab) {
        pBook.remove(ab);
        System.out.println("\nАбонент " + ab.getFio() + " удален.");
    }

    public static void searchName(List<Abonent12> pBook, String name) {
        AtomicInteger i = new AtomicInteger(pBook.size());
        pBook.stream()
                .map(Abonent12::getFio)
                .filter(s -> { if(s.contains(name)) {
                    System.out.println("Абонент " + name + " найден.");
                    } else {
                    i.getAndDecrement();
                    }
                    if (i.get() == 0) {
                        System.out.println("Абонент " + name + " не найден.");
                    }
                    return s.contains(name);})
                .forEach(s -> {});
    }

    public static void searchNumber(List<Abonent12> pBook, String nr) {
        pBook.stream()
                .map(abonent12 -> {
                    List<String> num = abonent12.getPhoneNrs();
                    String fio = abonent12.getFio();
                    String rez = new StringBuilder().append("Абонент ")
                            .append(fio).append(" номер(а): ").append(num).toString();
                    return rez;
                })
                .filter(s -> s.contains(nr))
                .forEach(System.out::println);
    }

    public static void searchAny(List<Abonent12> pBook, String any) {
        pBook.stream()
                .map(abonent12 -> {
                    List<String> num = abonent12.getPhoneNrs();
                    String fio = abonent12.getFio();
                    LocalDate date = abonent12.dateOfBirth;
                    String adr = abonent12.getAddress();
                    String rez = new StringBuilder().append("Данные поиска: << ").append(any)
                            .append(" >>. Результат >>> Абонент ").append(fio)
                            .append(", номер(а): ").append(num)
                            .append(", адрес - ").append(adr)
                            .append(", дата рождения - ").append(date).toString();
                    return rez;
                })
                .filter(s -> s.contains(any))
                .forEach(System.out::println);
    }




    public static void editAbonent(List<Abonent12> pBook, String name, String newName) {
        int i = -1;
        for (Abonent12 p : pBook) {
            if (Objects.equals(p.getFio(), name)) {
                p.setFio(newName);  //phoneBook.get(1).setFio("Чичваркин");
                System.out.println("\nАбоненту " + name + " установлено ФИО  " + newName + "\n   ***** ");
                i++;
            }
        }
        if (i == -1) {
            System.out.println("Абонента " + name + " нет в телефонной книге. Невозможно отредактировать.");
        }
    }

    public static void editAbonentPhone(List<Abonent12> pBook, String name, List<String> newNum) {
        int i = -1;
        for (Abonent12 p : pBook) {
            if (Objects.equals(p.getFio(), name)) {
                p.setPhoneNrs(newNum);  //phoneBook.get(1).setFio("Чичваркин");
                System.out.println("\nАбоненту " + name + " установлен(ы) номера  " + newNum + "\n   ***** ");
                i++;
            }
        }
        if (i == -1) {
            System.out.println("Абонента " + name + " нет в телефонной книге. Невозможно отредактировать.");
        }
    }
}