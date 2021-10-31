package com.pb.khantimerov.hw5;

import com.pb.khantimerov.hw3.Array;

/**
 * +Класс Reader хранит такую информацию о пользователе библиотеки:
 * + ФИО
 * + номер читательского билета
 * + факультет
 * + дата рождения
 * + телефон
 * Имеет перегруженные методы takeBook() , returnBook() :
 * + takeBook, который будет принимать количество взятых книг.
 * + takeBook, который будет принимать переменное количество названий книг.
 * + takeBook, который будет принимать переменное количество объектов класса Book.
 */

public class Reader {
    private String fio, faculty, dateBirth, phoneNum;
    private int readersNum;
    private static int readersCount = 0;
    public static int getReadersCount() {
        return readersCount;
    }

    public Reader (String fio, int readersNum, String faculty, String dateBirth, String phoneNum) {
        this.fio = fio;
        this.readersNum = readersNum;
        this.faculty = faculty;
        this.dateBirth = dateBirth;
        this.phoneNum = phoneNum;
        readersCount++;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getReadersNum() {
        return readersNum;
    }

    public void setReadersNum(int readersNum) {
        this.readersNum = readersNum;
    }

    String getReaderInfo() {
        return getFio() + ", читательский билет № " + getReadersNum() + ", факультет: " + getFaculty() + ",\n\tд.р.: "
                + getDateBirth() + ", тел. номер: " + getPhoneNum() + ".";
    }

//  Методы получения и возврата книг
    // фиксированное кличество книг
    public void takeBook(int bookNum) {
        System.out.println(fio + " взял " + bookNum + " книги.");
    }

    public void returnBook (int bookNum)
    {
        System.out.println(fio + " вернул " + bookNum + " книги.");
    }

    // несколько книг
    public void takeBook(String... books) {
        System.out.println("\n" + fio + " взял книги: ");
            for (String book : books) {
                System.out.print(book + ", ");
            }
        System.out.print("\b\b.\n");
        }

    public void returnBook(String... books) {
        System.out.println("\n" + fio + " вернул книги: ");
        for (String book : books) {
            System.out.print(book + ", ");
        }
        System.out.print("\b\b.\n");
    }
    // книги-объекты

    public void takeBook(Book... books) {
        System.out.println("\n" + fio + " взял книги: ");
        for (Book book : books) {
            System.out.print(book.getBookInfo2() + ", ");
        }
        System.out.print("\b\b.\n");
    }

    public void returnBook(Book... books) {
        System.out.println("\n" + fio + " вернул книги: ");
        for (Book book : books) {
            System.out.print(book.getBookInfo2() + ", ");
        }
        System.out.print("\b\b.\n");
    }

}