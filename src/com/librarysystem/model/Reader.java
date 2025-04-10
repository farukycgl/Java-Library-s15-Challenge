package com.librarysystem.model;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person {

    private List<Book> borrowedBooks = new ArrayList<>();
    private static final int MAX_BOOK_LIMIT = 5;

    public Reader(String name) {
        super(name);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean borrowBook(Book book){
        if(borrowedBooks.size() < MAX_BOOK_LIMIT) {
            borrowedBooks.add(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        return borrowedBooks.remove(book);
    }


    @Override
    public String whoYouAre() {
        return "Okuyucuyum.";
    }
}
