package model.service;

import jakarta.persistence.*;
import model.Author;
import model.Book;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public EntityManager getEntityManager() {

        return entityManager;
    }


    @Override
    public Author createAuthor(Author author) {

        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            getEntityManager().persist(author);
            System.out.println("The author inserted");

            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Author getAuthorById(Long authorId) {
        Author author = getEntityManager().find(Author.class, authorId);
//        EntityManager entityManager = EntityManage.getInstance().entityManager;
//        TypedQuery<Author> query = entityManager.createQuery("select a from Author a where id=authorId", Author.class);

        return author;
    }

    @Override
    public List<Author> getAllAuthors() {

        TypedQuery<Author> selectFromAuthor = getEntityManager().createQuery("select a from Author a", Author.class);

        return selectFromAuthor.getResultList();
    }


    // Sorus
    @Override
    public Author updateAuthor(Long id, Author author) {
        Author authorById = getAuthorById(id);
        getEntityManager().merge(authorById);
        return null;
    }

    @Override
    public void deleteAuthor(Long id) {
        Author authorById = getAuthorById(id);
        getEntityManager().remove(authorById);
        System.out.println("The author, id " + id + " deleted");
    }

    @Override
    public List<Book> getAllBooksByAuthor(Long authorId) {
        Author authorById = getAuthorById(authorId);
        TypedQuery<Book> query = entityManager.createQuery("SELECT e FROM Book e WHERE e.author = :author", Book.class);
        query.setParameter("author", authorById);
        return query.getResultList();
    }
}
