package com.librarysystem.service;

import com.librarysystem.model.*;



public class LibraryService {

    private Library library;
    private BillingService billingService;

    public LibraryService(Library library, BillingService billingService) {
        this.library = library;
        this.billingService = billingService;
    }

    public boolean borrowBook(Book book, Reader reader, MemberRecord memberRecord) {
        if(book.getStatus() == BookStatus.BORROWED) {
            System.out.println("Kitap zaten alınmış");
            return false;
        }
        if(!memberRecord.canBorrow()) {
            System.out.println("Kitap alma limiti dolmuş.");
            return false;
        }
        if(reader.borrowBook(book)) {
            library.lendBook(book, reader);
            memberRecord.incrementBooksIssued();
            billingService.charge(reader, 10.0);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book, Reader reader, MemberRecord memberRecord) {
        if(reader.returnBook(book)) {
            library.takeBackBook(book);
            memberRecord.decrementBooksIssued();
            billingService.refund(reader, 10.0);
            return true;
        }else {
            System.out.println("Kitap bu kullanıcıda değil.");
            return false;
        }
    }


}
