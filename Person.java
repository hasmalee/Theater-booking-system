package part_b;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private String surName;
    private String email;


    public Person() {
        // Compiler will add default data
    }
    public Person(String name, String surName, String email) {
        this.name = name;
        this.surName = surName;
        this.email = email;
    }


    public String getName() {
        return name;
    }
    public String getSurName() {
        return surName;
    }
    public String getEmail() {
        return email;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setSurName(String surName) {
        this.surName = surName;
    }
    public void setEmail(String email) {
        this.email = email;
    }

}
