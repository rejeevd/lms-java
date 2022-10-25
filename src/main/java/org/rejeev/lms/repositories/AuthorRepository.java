package org.rejeev.lms.repositories;

import org.rejeev.lms.model.Author;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthorRepository extends AbstractRepository {
    private static final Logger logger = LoggerFactory.getLogger(AuthorRepository.class);
    public static Author create(Author author){
        setDefaultValues(author);
        return AbstractRepository.createEntity(author);
    }

    public static Author update(Author author){
        setDefaultValues(author);
        return AbstractRepository.updateEntity(author);
    }

    public static Author getById(int id){
        return AbstractRepository.getEntityById(id, Author.class);
    }

    private static void setDefaultValues(Author author){
        AbstractRepository.populateDefaultValues(author);
    }
}
