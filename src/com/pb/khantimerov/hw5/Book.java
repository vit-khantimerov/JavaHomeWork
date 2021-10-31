package com.pb.khantimerov.hw5;

/**
 * Класс Book хранит такую информацию о книге:
 * + название
 * + автор книги
 * + год издания
 */

public class Book {
    private static int bookCount = 0;
    public static int getBookCount() {
        return bookCount;
    }

    private String title, author;
    private int year;

    public Book (String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
        bookCount++;
    }

    public Book() {
        this.title = "Некое название";
        this.author = "Инкогнито";
        this.year = 1000;
        bookCount++;
    }

    public String getTitle() {return title;}

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {this.author = author;}

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    String getBookInfo() {
        return "Название: " + getTitle() + ", автор: " + getAuthor() + ", год: " + getYear() + ".";
    }
    String getBookInfo2() {
        return getTitle() + " (" + getAuthor() + ", " + getYear() + "г.)";
    }
}
