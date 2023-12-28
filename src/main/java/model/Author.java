package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "authors")
/*
Many to Many-de ve ya basqa relation-larda yaranan 3 - cu cedvel gedir dusur DB - da avtomatik publice
onun yaranacagi schemani secmek olur??
 */


public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    private LocalDate death;

    private String nationality;

    @OneToMany(mappedBy = "author")
    private List<Book> books;


    public Author() {

    }

    public Author(String name, String surname, LocalDate birthDate, LocalDate death, String nationality) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.death = death;
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", death=" + death +
                ", nationality='" + nationality + '\'' +
                ", books=" + books +
                '}';
    }
}
