package com.pb.khantimerov.hw5;
import java.util.Random;


/**
 * + Класс Library используется как демонстрация работы классов Book и Reader.
 * + Имеет метод main() в котором создается массивы объектов Book и Reader, по 3 или более элементов в каждом.
 * Выполняются такие действия:
 * + печатаются все книги.
 * + печатаются все читатели.
 * + демонстрируется работа всех вариантов методов takeBook() и returnBook().
 */

public class Library {
    public static void main(String[] args) {
        Book bookJava = new Book("\"Java for beginners\"", "Shkabara A.", 2021);
        Book bookPBank = new Book();
        Book book3 = new Book("\"Auxiliary book instance\"", "Khantimerov V.", 2021);

        Reader ivanov = new Reader("Иванов И.И.", 101, "Химия", "01/10/2000", "067-555-55-55");
        // остальные пользователи создадутся позже

        int countBook = Book.getBookCount(), countReader;
        Book[] bookArray = new Book[countBook + 1]; // одну книгу создадим прямо в массив позже
        Reader[] readerArray = new Reader[4];

        bookArray[0] = bookJava;
        bookArray[1] = bookPBank;
        bookArray[2] = book3;
        bookArray[3] = new Book("\"Кобзарь\"", "Тарас Шеченко", 1840);

        readerArray[0] = ivanov;
        readerArray[1] = new Reader("Джавов Д.Ж.", 102, "ИТ", "15/07/1978", "050-555-55-55");
        readerArray[2] = new Reader("Хантимеров В.Г.", 103, "Физический", "03/08/1927", "067-555-61-05");
        readerArray[3] = new Reader("Оливо Д.Р.", 104, "Робототехника", "01/01/3000", "011-111-11-11");
        countReader = Reader.getReadersCount();


        bookArray[1].setTitle("\"Biggest Bank\"");
        bookArray[1].setAuthor("Tigipko S.L.");
        bookArray[1].setYear(1992);

        booksToConsole(bookArray, readerArray.length);
        System.out.println("\nВ библиотеку записано " + countReader + " человека.");
        readersToConsole(readerArray);

        System.out.println("\nБиблиотека открыта, сейчас прийдут чататели.\n");
        Random random = new Random();
        int rndBook;
        for (Reader reader: readerArray) {
            rndBook = random.nextInt(countBook + 1); // +1 т.к. 0 почти не выпадает
            reader.takeBook(countBook - rndBook + 1);
            reader.returnBook(countBook - rndBook + 1);
        }

        // кол-во книг у читателей выше и ниже никак не связано
        // ниже только демонстрируются перегруженные методы
        // можно было бы доделать выше "получение и возврат случайных книг"


        ivanov.takeBook(bookJava.getTitle(), bookArray[1].getTitle(), bookArray[2].getTitle(), bookArray[3].getTitle());
        readerArray[1].returnBook(bookJava.getTitle(), bookArray[1].getTitle(), bookArray[2].getTitle(), bookArray[3].getTitle());

        readerArray[2].takeBook(bookArray);
        readerArray[3].returnBook(bookJava, bookArray[1]);

        System.out.println("\nБиблиотека закрыта :)");
    }

    public static void booksToConsole (Book[] arr, int count) {
        System.out.println("Полный список книг (всего " + count + "):");
        for (Book book : arr) {
            System.out.println(book.getBookInfo());
        }
    }

    public static void readersToConsole (Reader[] arr) {
        System.out.println("\nСписок читателей:");
        for (Reader reader: arr) {
            System.out.println(reader.getReaderInfo());
        }
    }

}
