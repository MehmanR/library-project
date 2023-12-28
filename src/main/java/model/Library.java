package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Setter
@Getter
@Entity
@Table(name = "libraries")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String address;
    private String contact;
    @ManyToMany(mappedBy = "libraries")
    private List<Book> books;

    public Library(){

    }

    public Library(String name, String address, String contact) {
        this.name = name;
        this.address = address;
        this.contact = contact;
    }
}
