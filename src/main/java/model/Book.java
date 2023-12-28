package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    @Column(name = "ISBN", unique = true)
    private String isbn;

    @Column(name = "publication_year")
    private LocalDate publicationYear;

    private String description;

    private String language;
    @Column(name = "avaiable_copies")
    private int availableCopies;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Author author;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})

    private List<Library> library;


    public Book(){

    }
    public Book(String title, String isbn, LocalDate publicationYear,
                String description, String language, int availableCopies, Author author, List<Library> libraries) {
        this.title = title;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.description = description;
        this.language = language;
        this.availableCopies = availableCopies;
        this.author = author;
        this.library = libraries;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publicationYear=" + publicationYear +
                ", description='" + description + '\'' +
                ", language='" + language + '\'' +
                ", availableCopies=" + availableCopies +
                ", libraries=" + library +
                '}';
    }
}
