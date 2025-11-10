package com.MiniProject;

import java.io.*;
import java.util.*;
class InvalidReturnException extends Exception {
    public InvalidReturnException(String message) {
        super(message);
    }
}
class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean isIssued;
    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
    public void issueBook() {
        this.isIssued = true;
    }

    public void returnBook() {
        this.isIssued = false;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public int getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId + " | Title: " + title + " | Author: " + author +
                " | Status: " + (isIssued ? "Issued" : "Available");
    }
}
class Member {
    private int memberId;
    private String name;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + " | Name: " + name;
    }
}

class Library {
    private HashMap<Integer, Book> books = new HashMap<>();
    private HashMap<Integer, Member> members = new HashMap<>();
    private HashMap<Integer, Integer> issuedBooks = new HashMap<>();

    // Add new book
    public void addBook(Book b) {
        books.put(b.getBookId(), b);
        logOperation("Added Book: " + b);
    }

    public void addMember(Member m) {
        members.put(m.getMemberId(), m);
        logOperation("Added Member: " + m);
    }
    public void issueBook(int bookId, int memberId) throws InvalidReturnException {
        Book b = books.get(bookId);
        Member m = members.get(memberId);

        if (b == null)
            throw new InvalidReturnException("Book not found!");
        if (m == null)
            throw new InvalidReturnException("Member not found!");
        if (b.isIssued())
            throw new InvalidReturnException("Book already issued!");

        b.issueBook();
        issuedBooks.put(bookId, memberId);
        logOperation("Book issued: " + b + " to " + m);
        System.out.println(" Book issued successfully to " + m.getMemberId() + " (" + m.toString() + ")");
    }
    public void returnBook(int bookId, int daysLate) throws InvalidReturnException {
        Book b = books.get(bookId);

        if (b == null)
            throw new InvalidReturnException("Book not found!");
        if (!b.isIssued())
            throw new InvalidReturnException("This book was not issued!");

        b.returnBook();
        issuedBooks.remove(bookId);
        double fine = calculateLateFee(daysLate);
        logOperation("Book returned: " + b + " | Late Fee: ₹" + fine);
        System.out.println("Book returned successfully. Late Fee: ₹" + fine);
    }
    public double calculateLateFee(int daysLate) {
        return (daysLate > 0) ? daysLate * 5.0 : 0.0;
    }
    public void displayBooks() {
        System.out.println("\n📚 Library Books:");
        for (Book b : books.values()) {
            System.out.println(b);
        }
    }
    private void logOperation(String msg) {
        try (FileWriter fw = new FileWriter("library_log.txt", true)) {
            fw.write(new Date() + " - " + msg + "\n");
        } catch (IOException e) {
            System.out.println("⚠️ Error writing log file: " + e.getMessage());
        }
    }
}
public class LibraryMs{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n=======  LIBRARY MENU  =======");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Book ID: ");
                        int bookId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();
                        lib.addBook(new Book(bookId, title, author));
                        System.out.println(" Book added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter Member ID: ");
                        int memberId = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Member Name: ");
                        String name = sc.nextLine();
                        lib.addMember(new Member(memberId, name));
                        System.out.println(" Member added successfully!");
                        break;

                    case 3:
                        System.out.print("Enter Book ID to Issue: ");
                        int issueBookId = sc.nextInt();
                        System.out.print("Enter Member ID: ");
                        int issueMemberId = sc.nextInt();
                        lib.issueBook(issueBookId, issueMemberId);
                        break;

                    case 4:
                        System.out.print("Enter Book ID to Return: ");
                        int returnBookId = sc.nextInt();
                        System.out.print("Enter Days Late: ");
                        int daysLate = sc.nextInt();
                        lib.returnBook(returnBookId, daysLate);
                        break;

                    case 5:
                        lib.displayBooks();
                        break;

                    case 6:
                        System.out.println("Exiting... Thank you!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } catch (InvalidReturnException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
