package com.librarysystem.model;

import java.time.LocalDate;


public class Book {

    private String bookID;
    private String name;
    private Author author;
    private String edition;
    private LocalDate dateOfPurchase;
    private BookStatus status;
    private BookCategory category;

    public Book(String bookID, String name, Author author, String edition, LocalDate dateOfPurchase, BookCategory category){
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.category = category;
        this.status = BookStatus.AVALIABLE;
    }

    public String getBookID() {
        return bookID;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public String getEdition() {
        return edition;
    }

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public BookStatus getStatus() {
        return status;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void display(){
        System.out.println("ID: " + bookID+
                ", Ad: " +name+
                ", Yazar: " +author.getName()+
                ", Kategori: " +category+
                ", Durum: " +status);
    }

    @Override
    public String toString() {
        return "ID: " + bookID +
                ", Ad: " + name +
                ", Yazar: " + author.getName() +
                ", Baskı: " + edition +
                ", Yayın Tarihi: " + dateOfPurchase +
                ", Kategori: " + category +
                ", Durum: " + status;
    }

}
