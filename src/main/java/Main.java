import model.Author;
import model.Book;
import model.Library;
import model.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction transaction = entityManager.getTransaction();

        Author author = new Author("Jon" ,"Jones", LocalDate.of(1965,10,5),
                LocalDate.of(2010,12,1),"English");

        Library library = new Library("Axundov","Hasan Aliyev 47","055232332");
        List<Library> libraries = new ArrayList<>();
        libraries.add(library);

        Book book = new Book("History of Europa" ,"AfrikaFar" ,LocalDate.of(1998,4,26),
                "La Santa Monica","English" ,15000, author,libraries);


        AuthorService authorService = new AuthorServiceImpl();
        BookService bookService = new BookServiceImpl();
        LibraryService libraryService = new LibraryServiceImpl();

        List<Book> allBooksByAuthor = authorService.getAllBooksByAuthor(2L);
        System.out.println(allBooksByAuthor);




    }

}
