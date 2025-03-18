package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book fantastic = new Book("Фантастика", 3116);
        Book detective = new Book("Детективы", 1285);
        Book psychology = new Book("Психология", 1756);
        Book programming = new Book("Clean code", 704);

        Book[] books = new Book[4];
        books[0] = fantastic;
        books[1] = detective;
        books[2] = psychology;
        books[3] = programming;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getNumberOfPages());
        }
        System.out.println("Переставляем местами книги с индексами 0 и 3:");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + " - " + book.getNumberOfPages());
        }
        System.out.println("Clean code");
        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println(books[i].getName() + " - " + books[i].getNumberOfPages());
            }
        }
    }
}
