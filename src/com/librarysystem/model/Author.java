package com.librarysystem.model;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person{
    private List<Book> books = new ArrayList<>();

    public Author(String name){
        super(name);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String whoYouAre() {
       return "Ben bir yazarım.";
    }
}
