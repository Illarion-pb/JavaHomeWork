package com.pb.chesnokov.hw5;

public class Book {
    private static int booksCount = 0;

    private String bookName;
    private String bookAuthor;
    private int bookYear;

    public static String bookFormat(int num) {
        return num + " книг" + (((num >= 5 && num <=20) || (num % 10 >= 5))?"":(num % 10 == 1)?"у":"и");
    }

    public static String getBooksCount() {
        return bookFormat(booksCount);
    }

    public Book(String bn, String ba, int by) {
        this.bookName = bn;
        this.bookAuthor = ba;
        this.bookYear = by;

        booksCount ++;
    }

    public String getInfo() {
        return "\"" + bookName + "\" (автор - " + bookAuthor + ", " + bookYear + " год.)";
    }

    public String getShortInfo() {
        return "   - \"" + bookName + "\" (" + bookAuthor + " [" + bookYear + "])";
    }
}
