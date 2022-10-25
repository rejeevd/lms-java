package org.rejeev.lms.repositories;

import org.rejeev.lms.model.BookInventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InventoryRepository extends AbstractRepository {
    private static final Logger logger = LoggerFactory.getLogger(InventoryRepository.class);
    public static BookInventory create(BookInventory inventory){
        setDefaultValues(inventory);
        return AbstractRepository.createEntity(inventory);
    }

    public static BookInventory update(BookInventory inventory){
        setDefaultValues(inventory);
        return AbstractRepository.updateEntity(inventory);
    }

    public static BookInventory getById(int id){
        return AbstractRepository.getEntityById(id, BookInventory.class);
    }

    private static void setDefaultValues(BookInventory inventory){
        AbstractRepository.populateDefaultValues(inventory);
    }
}
