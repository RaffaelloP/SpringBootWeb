package org.its.pl.user;

public class Utente {

    private int id;
    private  String name;

    public Utente(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public  Utente(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
