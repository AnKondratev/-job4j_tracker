package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean Code");
        Book headFirst = new Book("Head First");
        Book thinkJava = new Book("Think Java");
        Book thinkDataStructures = new Book("Think Data Structures");
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = headFirst;
        books[2] = thinkJava;
        books[3] = thinkDataStructures;
        for (int index = 0; index < books.length; index++) {
            Book pr = books[index];
            System.out.println(pr.getName());
        }
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        System.out.println();
        for (Book pr : books) {
            System.out.println(pr.getName());
        }
        System.out.println();
        for (Book pr : books) {
            if ("Clean Code".equals(pr.getName())) {
                System.out.println(pr.getName());
            }
        }
    }
}




