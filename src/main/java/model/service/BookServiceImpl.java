package model.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.Book;

import java.util.List;

public class BookServiceImpl implements BookService{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();


//    public EntityManager getEntityManager() {
//
//        return entityManager;
//    }
    @Override
    public Book createBook(Book book) {

        try {
            transaction.begin();
            entityManager.persist(book);
            System.out.println("The book inserted");
            transaction.commit();
        }catch (Exception ex){
            transaction.rollback();
            System.out.println(ex.getMessage());
        }
        return null;
    }


    @Override
    public Book getBookById(Long id) {
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return null;
    }

    @Override
    public Book updateBook(Long id, Book book) {
        return null;
    }

    @Override
    public void deleteBook(Long id) {

    }

    @Override
    public List<Book> searchBookByTitle(String title) {
        return null;
    }
}
