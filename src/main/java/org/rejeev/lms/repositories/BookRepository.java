package org.rejeev.lms.repositories;

import org.rejeev.lms.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookRepository extends AbstractRepository {
    private static final Logger logger = LoggerFactory.getLogger(BookRepository.class);
    public static Book create(Book book){
        setDefaultValues(book);
        return AbstractRepository.createEntity(book);
    }

    public static Book update(Book book){
        setDefaultValues(book);
        return AbstractRepository.updateEntity(book);
    }

    public static Book getById(int id){
        return AbstractRepository.getEntityById(id, Book.class);
    }

    private static void setDefaultValues(Book book){
        AbstractRepository.populateDefaultValues(book);
    }
}
