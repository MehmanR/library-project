package model.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Library;

import java.util.List;

public class LibraryServiceImpl implements LibraryService{
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgres");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public Library createLibrary(Library library) {
        if (library != null) {
            entityManager.persist(library);
            System.out.println("The library inserted");
        }
        return null;
    }

    @Override
    public Library getLibraryById(Long id) {
        return null;
    }

    @Override
    public List<Library> getAllLibrary() {
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {

        return null;
    }

    @Override
    public void deleteLibrary(Long id) {

    }

    @Override
    public void addBookToLibrary(Long libraryId, Long bookId, int numberOfCopies) {

    }


}
