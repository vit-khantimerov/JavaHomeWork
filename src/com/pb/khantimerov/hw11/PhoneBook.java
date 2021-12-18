package com.pb.khantimerov.hw11;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;


public class PhoneBook {
    public static void main(String[] args) throws Exception {
        File bookPath = Paths.get("src/com/pb/khantimerov/hw11/phonebook.data").toFile();
        File jsonPath = Paths.get("src/com/pb/khantimerov/hw11/phonebook.json").toFile();
        FileInputStream fileInputStreamBook = new FileInputStream(bookPath);
        ObjectInputStream objectInputStreamBook = new ObjectInputStream(fileInputStreamBook);

        List<Abonent> phoneBook = new ArrayList<>();
/*
      Пробовал вариант сначала грузить книгу из файла, а потом работать с ней,
   но не понраилось: после каждого запуска программы книга увеличивалась за счет
   нескольких одинаковых абонентов.

   List<Abonent> phoneBook = (List<Abonent>) objectInputStreamBook.readObject();
 */

        System.out.println("  *** СОЗДАЕМ ТЕЛЕФОННУЮ КНИГУ ***  ");

        Abonent abonent1 = new Abonent("Хантимеров",
                LocalDate.of(1972, 3, 8),
                Arrays.asList("0675555555", "0991111111", "0552325325"),
                "Херсон", LocalDateTime.of(2021, 12, 16, 10, 20));
        Abonent abonent2 = new Abonent("Чичиков",
                LocalDate.of(1977, 8, 3),
                Arrays.asList("0672222222", "0999999222", "0552325325"),
                "Херсон", LocalDateTime.of(2021, 12, 16, 10, 30));
        Abonent abonent3 = new Abonent("Third",
                LocalDate.of(1933,3,13),
                Arrays.asList("093333333333", "0993333333"), "Николаев",
                LocalDateTime.of(2021, 12, 17, 11, 23));
        Abonent abonent4 = new Abonent("Сидоров",
                LocalDate.of(1999, 12, 18),
                Arrays.asList("067333333", "0991133311", "0552111125"),
                "Харьков", LocalDateTime.of(2021, 12, 17, 9, 55));
        Abonent abonent5 = new Abonent("Исаев",
                LocalDate.of(2000, 10, 30),
                Arrays.asList("055555555", "099995555"),
                "Киев", LocalDateTime.of(2021, 12, 18, 20, 15));

        addAbonent(phoneBook,abonent1);
        addAbonent(phoneBook,abonent2);
        addAbonent(phoneBook,abonent3);
        addAbonent(phoneBook,abonent4);
        addAbonent(phoneBook,abonent5);


        //System.out.println("  *** ЗАГРУЖЕНА ТЕЛЕФОННАЯ КНИГА ***  ");
        System.out.println("\nКоличество абонентов " + phoneBook.size() + ".");
        phoneBookPrint(phoneBook);

        addAbonent(phoneBook,abonent5);
        delAbonent(phoneBook,phoneBook.get(4));

        System.out.println();

        System.out.println("\nДанные абонента 2: " + phoneBook.get(1));
        System.out.println("\nДанные абонента 3: " + abonent4);
        System.out.println("\nПорядковый номер " + phoneBook.get(1).getFio()
                + " в списке № " + phoneBook.indexOf(phoneBook.get(1)));

        System.out.println();

        searchName(phoneBook,"Third");
        searchName(phoneBook, "Second");
        searchNumber(phoneBook, "0675555555");
        searchNumber(phoneBook, "0922225855");
        searchNumber(phoneBook, "0552325325");

        System.out.println();

        editAbonent(phoneBook,"Third", "Авдеев");
        editAbonent(phoneBook, "Сидоров", "Федоров");
        searchName(phoneBook,"Third");

        editAbonentPhone(phoneBook, "Федоров", Arrays.asList("77777", "88888888", "9999999", "1010101"));
        editAbonentPhone(phoneBook,"Некто",Arrays.asList("01010101"));

        //editAbonent (List<Abonent> pBook, String name, String newName)

        System.out.println("\n   *** Варианты сортировки  ***");

        phoneBook.sort(Comparator.comparing(p -> p.fio));
        System.out.println("Сортирока по фамилии.\n" + phoneBook + "\n");

        phoneBook.sort(Comparator.comparing(p -> p.dateOfBirth));
        System.out.println("Сортировка по дате рождения.\n" + phoneBook + "\n");

        //сортировка по полю age
        phoneBook.sort(Comparator.comparing(p -> p.edited));
        System.out.println("Сортирока по дате и времени изменения.\n" + phoneBook + "\n");


// Запись и чтение телефонной книги

        ObjectMapper mapper = new ObjectMapper();
        // pretty printing (json с отступами)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // работа с полями типа LocalDate
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer());
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
        mapper.registerModule(module);

        // работа с полями типа LocalDateTime
        SimpleModule moduleDT = new SimpleModule();
        moduleDT.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        moduleDT.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
        mapper.registerModule(moduleDT);

        String json = mapper.writeValueAsString(phoneBook);
        //System.out.println("\n\nТелефонная книга в формате JSON \n" + json);

        FileOutputStream outputStreamBook = new FileOutputStream(bookPath);
        FileOutputStream outputStreamJSON = new FileOutputStream(jsonPath);
        ObjectOutputStream objectOutputStreamBook = new ObjectOutputStream(outputStreamBook);
        ObjectOutputStream objectOutputStreamJSON = new ObjectOutputStream(outputStreamJSON);

        // сохраняем в файл
        objectOutputStreamBook.writeObject(phoneBook);
        objectOutputStreamJSON.writeObject(json);

//        List<Person> persons = (List<Person>) objectInputStream.readObject();
//        System.out.println(persons);

        objectOutputStreamBook.close();
        objectOutputStreamJSON.close();

//

        File bookPath2 = Paths.get("src/com/pb/khantimerov/hw11/phonebook.data").toFile();

        FileInputStream fileInputStreamBook2 = new FileInputStream(bookPath2);
        ObjectInputStream objectInputStreamBook2 = new ObjectInputStream(fileInputStreamBook2);

        List<Abonent> book_2 = (List<Abonent>) objectInputStreamBook2.readObject();

        System.out.println("\n      ***********************  \nТелефоная книга 2, класс " + book_2.get(0).getClass().getSimpleName() + ".");
        System.out.println(book_2);
        objectInputStreamBook2.close();


// Не получилось прочитать JSON-файл, ошибка jackson.core.JsonParseException: Unexpected character ('¬' (code 172)): expected a valid value

//        FileInputStream fileInputStreamJSON = new FileInputStream(jsonPath);
//        ObjectInputStream objectInputStreamJSON = new ObjectInputStream(fileInputStreamJSON);
//
//        List<Abonent> book_JSON = mapper.readValue(jsonPath, new TypeReference <List<Abonent>>(){});
//        List<Abonent> book_JSON = Arrays.asList(mapper.readValue(Paths.get("src/com/pb/khantimerov/hw11/phonebook0.json").toFile(), Abonent[].class));
//
//        System.out.println("book JSON \n" + book_JSON);
//        objectInputStream.close();

    } // *** END OF PSV MAIN ***

    public static void addAbonent(List<Abonent> pBook, Abonent ab) {
        pBook.add(ab);
        System.out.println("\nАбонент " + ab.getFio() + " добавлен.");
    }

    public static void delAbonent(List<Abonent> pBook, Abonent ab) {
        pBook.remove(ab);
        System.out.println("\nАбонент " + ab.getFio() + " удален.");
    }

    public static void searchName(List<Abonent> pBook, String name) {
        int i = -1;
        for (Abonent p : pBook) {
            if (Objects.equals(p.getFio(), name)) {
                System.out.println("\nАбонент " + name + " найден. \n" + p + "\n   ***** ");
                i++;
                break;
            }
        }
        if (i == -1) {
            System.out.println("Абонента " + name + " Нет в телефонной книге." + "\n   ***** ");
        }
    }

    public static void searchNumber(List<Abonent> pBook, String nr) {
        int i = -1;
        System.out.println("\nНомер " + nr);
        for (Abonent p : pBook) {
            //List<String> phoneNrs
            for (String n : p.getPhoneNrs()) {
//                System.out.println(p.getPhoneNrs());
                if (Objects.equals(n, nr)) {
                    System.out.println("найден у абонента " + p.getFio());
                    i++;
                }
            }
        }
        if (i == -1) {
            System.out.println("не найден в телефонной книге.\n");
        }
    }

    public static void phoneBookPrint(List<Abonent> pBook) {
        System.out.println("\n*** Полные данные абонентов ***");
        for (Abonent p : pBook) {
            System.out.println(p);
        }
        System.out.println("\n   *** ***** ***");
    }

    public static void editAbonent(List<Abonent> pBook, String name, String newName) {
        int i = -1;
        for (Abonent p : pBook) {
            if (Objects.equals(p.getFio(), name)) {
                p.setFio(newName);  //phoneBook.get(1).setFio("Чичваркин");
                System.out.println("\nАбоненту " + name + " установлено ФИО  " + newName + "\n   ***** ");
                i++;
            }
        }
        if (i == -1) {
            System.out.println("Абонента " + name + " Нет в телефонной книге. Невозможно отредактировать.");
        }
    }

    public static void editAbonentPhone(List<Abonent> pBook, String name, List<String> newNum) {
        int i = -1;
        for (Abonent p : pBook) {
            if (Objects.equals(p.getFio(), name)) {
                p.setPhoneNrs(newNum);  //phoneBook.get(1).setFio("Чичваркин");
                System.out.println("\nАбоненту " + name + " установлен(ы) номера  " + newNum + "\n   ***** ");
                i++;
            }
        }
        if (i == -1) {
            System.out.println("Абонента " + name + " Нет в телефонной книге. Невозможно отредактировать.");
        }
    }
}
