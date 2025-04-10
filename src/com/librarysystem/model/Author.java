package com.librarysystem.model;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person{
    private List<Book> books = new ArrayList<>();

    public Author(String name){
        super(name);
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String whoYouAre() {
       return "Ben bir yazarım.";
    }
}
