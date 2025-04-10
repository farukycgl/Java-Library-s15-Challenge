package com.librarysystem.service;

import com.librarysystem.model.Book;
import com.librarysystem.model.BookCategory;
import com.librarysystem.model.BookStatus;
import com.librarysystem.model.Library;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {

    private Library library;

    public BookService(Library library) {
        this.library = library;
    }

    public void addBook(Book book) {
        library.addBook(book);
        System.out.println("Kitap başarıyla eklendi.");
    }

    public boolean removeBookById(String id) {
        boolean result = library.removeBook(id);
        if(result) {
            System.out.println("Kitap başarıyla silindi.");
        }else{
            System.out.println("Kitap bulunamadı!");
        }
        return result;
    }

    public List<Book> searchByName(String name) {
        return library.getBooks().stream()
                .filter(book -> book.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Book> searchByAuthor(String authorName) {
        return library.getBooks().stream()
                .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                .collect(Collectors.toList());
    }

    public List<Book> searchByCategory(BookCategory category) {
        return library.getBooks().stream()
                .filter(book -> book.getCategory() == category)
                .collect(Collectors.toList());
    }

    public Book searchById(String id) {
        return library.getBooks().stream()
                .filter(book -> book.getBookID().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean updateBook(String id, String newName, String newEdition) {
        Book book = searchById(id);
        if(book != null) {
            book.setStatus(BookStatus.AVALIABLE);
            System.out.println("Kitap bilgileri güncellendi.");
            return true;
        }else {
            System.out.println("Kitap bulunamadı!");
            return false;
        }
    }

    public void displayBooks(List<Book> books) {
        books.forEach(Book::display);
    }

}
