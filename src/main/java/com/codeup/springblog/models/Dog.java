package com.codeup.springblog.models;


import javax.persistence.*;

@Entity
@Table(name = "Dog")
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 3)
    private byte age;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 2)
    private char reside_state;

    public Dog(long id, byte age, String name, char reside_state) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.reside_state = reside_state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getReside_state() {
        return reside_state;
    }

    public void setReside_state(char reside_state) {
        this.reside_state = reside_state;
    }

    public Dog(){

    }
}
