package com.java.me.dbapp.databases.jpa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons")
@NamedQuery(name = "find all persons",query = "select p from Persons p")
public class Persons
{
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;
    private String location;
    private Date birthDate;
    public Persons()
    {

    }
    public Persons(int id, String name, String location, Date birth_date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birthDate = birth_date;
    }
    public Persons(String name, String location, Date birth_date) {
        this.name = name;
        this.location = location;
        this.birthDate = birth_date;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "\n Persons{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
