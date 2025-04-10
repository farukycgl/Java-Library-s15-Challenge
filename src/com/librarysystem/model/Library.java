package com.librarysystem.model;

import java.util.*;

public class Library {
    private List<Book> books;
    private Set<Reader> readers;
    private Map<Book, Reader> borrowedRecords;

    public Library() {
        books = new ArrayList<>();
        readers = new HashSet<>();
        borrowedRecords = new HashMap<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public boolean removeBook(String id){
        return books.removeIf(book -> book.getBookID().equals(id));
    }

    public List<Book> getBooks() {
        return books;
    }

    public Set<Reader> getReaders(){
        return readers;
    }

    public Map<Book, Reader> getBorrowedRecords() {
        return borrowedRecords;
    }

    public void registerReader(Reader reader) {
        readers.add(reader);
    }

    public void lendBook(Book book, Reader reader) {
        book.setStatus(BookStatus.BORROWED);
        borrowedRecords.put(book, reader);
    }

    public void takeBackBook(Book book) {
        book.setStatus(BookStatus.AVALIABLE);
        borrowedRecords.remove(book);
    }

    public List<Book> findBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getName().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public Reader getBookOwner(Book book) {
        return borrowedRecords.get(book);
    }

}
