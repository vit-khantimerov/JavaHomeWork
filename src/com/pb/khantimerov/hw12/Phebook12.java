package com.pb.khantimerov.hw12;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.pb.khantimerov.hw11.*;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Phebook12 {
        public static void main(String[] args) throws Exception {
            File bookPath = Paths.get("src/com/pb/khantimerov/hw12/phonebook.data").toFile();
            File jsonPath = Paths.get("src/com/pb/khantimerov/hw12/phonebook.json").toFile();
//            FileInputStream fileInputStreamBook = new FileInputStream(bookPath);
//            ObjectInputStream objectInputStreamBook = new ObjectInputStream(fileInputStreamBook);

            List<Abonent12> phoneBook12 = new ArrayList<>();
/*
      Пробовал вариант сначала грузить книгу из файла, а потом работать с ней,
   но не понраилось: после каждого запуска программы книга увеличивалась за счет
   нескольких одинаковых абонентов.

   List<Abonent> phoneBook = (List<Abonent>) objectInputStreamBook.readObject();
 */

            System.out.println("  *** СОЗДАЕМ ТЕЛЕФОННУЮ КНИГУ ***  ");

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

            addAbonent(phoneBook12,abonent1);
            addAbonent(phoneBook12,abonent2);
            addAbonent(phoneBook12,abonent3);
            addAbonent(phoneBook12,abonent4);
            addAbonent(phoneBook12,abonent5);


            //System.out.println("  *** ЗАГРУЖЕНА ТЕЛЕФОННАЯ КНИГА ***  ");
            System.out.println("\nКоличество абонентов " + phoneBook12.size() + ".");
            phoneBookPrint(phoneBook12);

            addAbonent(phoneBook12,abonent5);
            delAbonent(phoneBook12,phoneBook12.get(4));

            System.out.println();

            System.out.println("\nДанные абонента 2: " + phoneBook12.get(1));
            System.out.println("\nДанные абонента 3: " + abonent4);
            System.out.println("\nПорядковый номер " + phoneBook12.get(1).getFio()
                    + " в списке № " + phoneBook12.indexOf(phoneBook12.get(1)));

            System.out.println();

            searchName(phoneBook12,"Third");
            searchName(phoneBook12, "Second");
            searchNumber(phoneBook12, "0675555555");
            searchNumber(phoneBook12, "0922225855");
            searchNumber(phoneBook12, "0552325325");

            System.out.println();

            editAbonent(phoneBook12,"Third", "Авдеев");
            editAbonent(phoneBook12, "Сидоров", "Федоров");
            searchName(phoneBook12,"Third");

            editAbonentPhone(phoneBook12, "Федоров", Arrays.asList("77777", "88888888", "9999999", "1010101"));
            editAbonentPhone(phoneBook12,"Некто",Arrays.asList("01010101"));

            //editAbonent (List<Abonent> pBook, String name, String newName)

            System.out.println("\n   *** Варианты сортировки  ***");

            phoneBook12.sort(Comparator.comparing(p -> p.fio));
            System.out.println("Сортирока по фамилии.\n" + phoneBook12 + "\n");

            phoneBook12.sort(Comparator.comparing(p -> p.dateOfBirth));
            System.out.println("Сортировка по дате рождения.\n" + phoneBook12 + "\n");

            //сортировка по полю age
            phoneBook12.sort(Comparator.comparing(p -> p.edited));
            System.out.println("Сортирока по дате и времени изменения.\n" + phoneBook12 + "\n");


// Запись и чтение телефонной книги

            ObjectMapper mapper = new ObjectMapper();
            // pretty printing (json с отступами)
            mapper.enable(SerializationFeature.INDENT_OUTPUT);

//            // работа с полями типа LocalDate
//            SimpleModule module = new SimpleModule();
//            module.addSerializer(LocalDate.class, new LocalDateSerializer());
//            module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
//            mapper.registerModule(module);
//
//            // работа с полями типа LocalDateTime
//            SimpleModule moduleDT = new SimpleModule();
//            moduleDT.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
//            moduleDT.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
//            mapper.registerModule(moduleDT);

            //String json = mapper.writeValueAsString(phoneBook12);
            //System.out.println("\n\nТелефонная книга в формате JSON \n" + json);

            FileOutputStream outputStreamBook = new FileOutputStream(bookPath);
            //FileOutputStream outputStreamJSON = new FileOutputStream(jsonPath);
            ObjectOutputStream objectOutputStreamBook = new ObjectOutputStream(outputStreamBook);
            //ObjectOutputStream objectOutputStreamJSON = new ObjectOutputStream(outputStreamJSON);

            // сохраняем в файл
            objectOutputStreamBook.writeObject(phoneBook12);
            //objectOutputStreamJSON.writeObject(json);

            objectOutputStreamBook.close();
            //objectOutputStreamJSON.close();

//

            File bookPath2 = Paths.get("src/com/pb/khantimerov/hw12/phonebook.data").toFile();

            FileInputStream fileInputStreamBook2 = new FileInputStream(bookPath2);
            ObjectInputStream objectInputStreamBook2 = new ObjectInputStream(fileInputStreamBook2);

            List<Abonent12> book_2 = (List<Abonent12>) objectInputStreamBook2.readObject();

            System.out.println("\n      ***********************  \nТелефоная книга 2, класс " + book_2.get(0).getClass().getSimpleName() + ".");
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
            int i = -1;
            for (Abonent12 p : pBook) {
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

        public static void searchNumber(List<Abonent12> pBook, String nr) {
            int i = -1;
            System.out.println("\nНомер " + nr);
            for (Abonent12 p : pBook) {
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

        public static void phoneBookPrint(List<Abonent12> pBook) {
            System.out.println("\n*** Полные данные абонентов ***");
            for (Abonent12 p : pBook) {
                System.out.println(p);
            }
            System.out.println("\n   *** ***** ***");
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
                System.out.println("Абонента " + name + " Нет в телефонной книге. Невозможно отредактировать.");
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
                System.out.println("Абонента " + name + " Нет в телефонной книге. Невозможно отредактировать.");
            }
        }
    }