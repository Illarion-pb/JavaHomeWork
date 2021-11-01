package com.pb.chesnokov.hw5;

import java.util.ArrayList;
import java.util.List;

//класс Library
public class Library {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("1984", "Джордж Оруэлл", 1949));
        books.add(new Book("Скотный двор", "Джордж Оруэлл", 1945));
        books.add(new Book("О дивный новый мир", "Олдос Хаксли", 1932));
        books.add(new Book("Остров", "Олдос Хаксли", 1962));
        books.add(new Book("Обезьяна и сущность", "Олдос Хаксли", 1948));

        List<Reader> readers = new ArrayList<>();
        readers.add(new Reader("Иванов И.И.", "ПР", "05/10/1992", "+380671112233"));
        readers.add(new Reader("Петров П.П.", "ЭК", "17/04/1991", "+380672223344"));
        readers.add(new Reader("Сидоров С.С.", "КСС", "07/07/1987", "+380673334455"));
        readers.add(new Reader("Александров А.А.", "ФЕА", "22/08/1990", "+380674445566"));

        System.out.printf("В нашей библиотеке - %s: \n", Book.getBooksCount());
        System.out.println("---------------------------");
        for (Book book: books) {
            System.out.println(book.getInfo());
        }

        System.out.println("---------------------------");
        System.out.printf("В нашей библиотеке - %s: \n", Reader.getReadersCount());
        System.out.println("---------------------------");
        for (Reader reader: readers) {
            System.out.println(reader.getInfo());
        }

        System.out.println("---------------------------");
        readers.get(0).takeBook(33);
        System.out.println("***************************");
        readers.get(1).takeBook(books.get(2), books.get(0), books.get(4));
        System.out.println("***************************");
        readers.get(2).returnBook(12);
        System.out.println("***************************");
        readers.get(3).returnBook(books.get(1), books.get(3));
        System.out.println("***************************");

    }
}
