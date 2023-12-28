package model;

import jakarta.persistence.*;

@Entity
public class BooksAndLibaries {//ele yolu budu 3cu tableni burada el ile yaratmaq

    @Id
    long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOK-id")
    Book book;


    long libary_id;
}
