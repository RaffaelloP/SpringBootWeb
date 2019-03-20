package org.its.dl.user;

import javax.persistence.*;

@Entity
@Table(name = "UtenteDL")
public class  UtenteDL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private  String name;
    @Column(name = "enabled")
    private boolean enabled;

    public UtenteDL(int id, String name, boolean enabled) {
        this.id = id;
        this.name = name;
        this.enabled = enabled;
    }

    public  UtenteDL(){}

    //remove id for saving on database (identity conflict)
    public UtenteDL(UtenteDL utenteDL){
        this.name = utenteDL.name;
        this.enabled = utenteDL.enabled;
    }

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setId(Integer integer) {
        this.id = id;
    }
}
