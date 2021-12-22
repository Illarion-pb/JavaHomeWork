//search for:
// new with stream!!!
// new with lambda!!!
package com.pb.chesnokov.hw12;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Person> persons = new ArrayList<>();
    private static String mainMenu = "*** Main menu *** \n v - more info; a - add; s - search; f - sort by fio; t - sort by first phone; w - write to file; r - read from file; q - quit";
    private static String recordMenu = "*** Person menu *** \n r - remove; e - edit; a - add phone; d - delete all phones; q - back to main manu";

    public static void printRecords() {
        // new with stream!!!
        final int[] counter = {0};
        persons.stream().peek(s -> counter[0]++)
                .map(person -> String.format("%d: %0$-30s  %s",
                        counter[0],
                        ((person.getFio().length()>30)?person.getFio().substring(0, 30):person.getFio()),
                        person.getPhone()))
                .forEach(System.out::println);
    }

    public static void toFile() throws Exception {
        File file = Paths.get("person.data").toFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        objectOutputStream.writeObject(persons);

        objectOutputStream.close();
    }

    public static void fromFile() throws Exception {
        File file = Paths.get("person.data").toFile();
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        persons.clear();
        persons = (List<Person>) objectInputStream.readObject();
    }

    public static void main(String[] args) {

        persons.add(new Person("Чесноков Илларион Александрович", "123456789", LocalDate.of(1983, 3, 13), "Потемкинская, 20"));
        persons.add(new Person("Иванов Иван Иванович", "234567890", LocalDate.of(1987, 8, 27), "Ивановская, 22"));
        persons.add(new Person("Петров Петр Петрович", "345678901", LocalDate.of(1988, 5, 22), "Петровская, 43"));
        persons.add(new Person("Сидоров Сидор Сидорович", LocalDate.of(1991, 4, 17), "Сидоровская, 10"));
        persons.add(new Person("Александров Александр Александрович", LocalDate.of(1985, 7, 23), "Александровская, 4"));

        persons.get(0).addPhone("012345678");
        persons.get(0).addPhone("111111111");
        persons.get(1).addPhone("222222222");
        System.out.println();
        Scanner in = new Scanner(System.in);
        String value, fio, adr;
        LocalDate bd;
        char ch;
        int num;
        Person person = new Person();

        printRecords();
        System.out.println(mainMenu);
        while (true) {
            ch = in.next().charAt(0);
            if (ch == 'q' || ch == 'Q') break;
            switch (ch) {
                case 'S':
                case 's':
                case 'V':
                case 'v': {
                    num = -1;
                    if (ch == 'V' || ch == 'v') {
                        System.out.print("Enter a rec number: ");
                        value = in.next();
                        try {
                            num = Integer.parseInt(value);
                            if (num > persons.size()) {
                                System.out.println("Out of bound.");
                                break;
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Not a number!");
                            break;
                        }
                    };
                    if (ch == 'S' || ch == 's') {
                        System.out.print("Search by: 1 - fio, 2 - phone, 3 - address: ");
                        ch = in.next().charAt(0);
                        in.nextLine();
                        System.out.print("Enter search line: ");
                        // new with stream!!!
                        final String value1 = in.nextLine();
                        try {
                            if (ch == '1')
                                num = persons.indexOf(persons.stream().filter(p -> p.getFio().equals(value1)).findFirst().get()) + 1;
                            else if (ch == '2')
                                num = persons.indexOf(persons.stream().filter(p -> p.phoneCheck(value1)).findFirst().get()) + 1;
                            else if (ch == '3')
                                num = persons.indexOf(persons.stream().filter(p -> p.getAddress().equals(value1)).findFirst().get()) + 1;
                        } catch (Exception ex) {
                            System.out.println("Не найдено!");
                        }
                    }
                    if (num == -1) break;
                    System.out.println(persons.get(num - 1).getInfo());
                    System.out.println(recordMenu);
                    while (true) {
                        ch = in.next().charAt(0);
                        if (ch == 'q' || ch == 'Q') break;
                        if (ch == 'r' || ch == 'R') {
                           persons.remove(num - 1);
                           break;
                        }
                        switch (ch) {
                            case 'A':
                            case 'a': {
                                System.out.print("Enter a phone number (9 digits): ");
                                value = in.next();
                                if (value.length() == 9) persons.get(num - 1).addPhone(value);
                                else System.out.println("Not 9 digits");
                                break;
                            }
                            case 'D':
                            case 'd': {
                                persons.get(num - 1).removePhones();
                                break;
                            }
                            case 'E':
                            case 'e': {
                                in.nextLine();
                                fio = persons.get(num -1).getFio();
                                bd = persons.get(num -1).getBirth();
                                adr = persons.get(num -1).getAddress();
                                System.out.println("Enter new values, or empty if not change");
                                System.out.println("Fio (old value): " + fio);
                                System.out.print("Enter new fio: ");
                                value = in.nextLine();
                                fio = (value.isEmpty())?fio:value;
                                System.out.println("Birthdate (old value): " + bd);
                                System.out.print("Enter new birthdate (in format \"yyyy-mm-dd\"): ");
                                value = in.nextLine();
                                bd = (value.isEmpty())?bd:LocalDate.parse(value);
                                System.out.println("Adress (old value): " + adr);
                                System.out.print("Enter new address: ");
                                value = in.nextLine();
                                adr = (value.isEmpty())?adr:value;
                                persons.get(num -1).edit(fio, bd, adr);
                                break;
                            }
                        }
                        System.out.println(persons.get(num - 1).getInfo());
                        System.out.println(recordMenu);
                    }
                    break;
                }
                case 'A':
                case 'a': {
                    in.nextLine();
                    System.out.print("Enter Fio: ");
                    fio = in.nextLine();
                    System.out.print("Enter Birthdate (in format \"yyyy-mm-dd\"): ");
                    value = in.nextLine();
                    bd = LocalDate.parse(value);
                    System.out.print("Enter an adress: ");
                    adr = in.nextLine();
                    persons.add(new Person(fio, bd, adr));
                    break;
                }
                // new with lambda
                case 'F':
                case 'f': {
                    persons.sort(Comparator.comparing(p -> p.getFio()));
                    break;
                }
                case 'T':
                case 't': {
                    persons.sort(Comparator.comparing(p -> p.getPhone()));
                    break;
                }
                case 'W':
                case 'w': {
                    try {
                        toFile();
                    }  catch (Exception ex) {}
                }
                case 'R':
                case 'r': {
                    try {
                        fromFile();
                    } catch (Exception ex) {}
                }
            }
            printRecords();
            System.out.println(mainMenu);
        }

    }
}
