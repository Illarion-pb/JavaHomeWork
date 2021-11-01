package com.pb.chesnokov.hw5;

import java.util.Formatter;


//класс Reader
public class Reader {
    private static int readersCount = 0;

    private String readerName;
    private String readerLibCard;
    private String readerFaculty;
    private String readerBirth;
    private String readerPhone;

    public static String readerFormat(int num) {
        return num + " читател" + (((num >= 5 && num <=20) || (num % 10 >= 5))?"ей":(num % 10 == 1)?"ь":"я");
    }

    public static String getReadersCount() {
        return readerFormat(readersCount);
    }

    public Reader(String rn, String rf, String rb, String rp) {
        Formatter libCardCreator = new Formatter();

        this.readerName = rn;
        this.readerLibCard = libCardCreator.format("%s%06d", rf.substring(0, 1), readersCount).toString();
        this.readerFaculty = rf;
        this.readerBirth = rb;
        this.readerPhone = rp;

        readersCount ++;
    }

    public String getInfo() {
        Formatter retValue = new Formatter();
        retValue.format("%s: номер читательского билета - %s; факультет - %s; дата рождения - %s; номер телефона - %s", readerName, readerLibCard, readerFaculty, readerBirth, readerPhone);
        return retValue.toString();
    }

    private  void printBooksNum(boolean isTake, int booksNum) {
        System.out.printf("%s %s %s \n", readerName, (isTake)?"взял":"вернул", Book.bookFormat(booksNum));
    }

    private void printBooksObj(boolean isTake, Book ... books) {
        System.out.printf("%s %s такие книги: \n", readerName, (isTake)?"взял":"вернул");
        for (Book book: books) {
            System.out.println(book.getShortInfo());
        }
    }

    public void takeBook(int booksNum) {
        printBooksNum(true, booksNum);
    }

    public void takeBook(Book ... books) {
        printBooksObj(true, books);
    }

    public void returnBook(int booksNum) {
        printBooksNum(false, booksNum);
    }

    public void returnBook(Book ... books) {
        printBooksObj(false, books);
    }
}
