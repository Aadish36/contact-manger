package com.smart.contact.manger.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="USER")
public class user {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
   private String Name;
    private String Email;
    private String Password;
    private String Role;
    private boolean enabled;
    private String imageurl;
    @Column(length = 500)
    private String about;
 @OneToMany(cascade = CascadeType.ALL)
    private List<contact> contacts= new ArrayList<>();

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about= about;
    }

    public List<contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Role='" + Role + '\'' +
                ", enabled=" + enabled +
                ", imageurl='" + imageurl + '\'' +
                ", about='" + about + '\'' +
                ", contacts=" + contacts +
                '}';
    }


}
