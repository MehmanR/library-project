package model.service;

import model.Library;

import java.util.List;

public interface LibraryService {

    Library createLibrary(Library library);

    Library getLibraryById(Long id);

    List<Library> getAllLibrary();

    Library updateLibrary(Long id, Library library);

    void deleteLibrary(Long id);

    void addBookToLibrary(Long libraryId, Long bookId, int numberOfCopies);


}
