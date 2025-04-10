package com.librarysystem.model;

import java.time.LocalDate;

public class MemberRecord {
    private String memberId;
    private LocalDate dateOfMembership;
    private int booksIssued;
    private final int maxBookLimit = 5;
    private Reader reader;

    public MemberRecord(String memberId, LocalDate dateOfMembership, Reader reader) {
        this.memberId = memberId;
        this.dateOfMembership = dateOfMembership;
        this.reader = reader;
        this.booksIssued = 0;
    }

    public boolean canBorrow() {
        return booksIssued < maxBookLimit;
    }

    public void incrementBooksIssued() {
        booksIssued++;
    }

    public void decrementBooksIssued() {
        booksIssued--;
    }

    public String getMemberId() {
        return memberId;
    }

    public Reader getReader() {
        return reader;
    }
}
