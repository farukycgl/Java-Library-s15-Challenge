package com.librarysystem.model;

public class Librarian extends Person{

    private String password;

    public Librarian(String name, String password){
        super(name);
        this.password = password;
    }

    public boolean verifyPassword(String input) {
        return password.equals(input);
    }


    @Override
    public String whoYouAre() {
        return "Ben bir kütüphaneciyim.";
    }
}
