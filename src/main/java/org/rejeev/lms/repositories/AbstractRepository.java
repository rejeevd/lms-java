package org.rejeev.lms.repositories;

import org.rejeev.lms.hibernate.HibernateUtil;
import org.rejeev.lms.model.AbstractEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractRepository {
    private static final Logger logger = LoggerFactory.getLogger(AbstractEntity.class);
    public static <T extends AbstractEntity> T createEntity(T entity){
        try {
            Session session = HibernateUtil.getCurrentSession();
            Transaction transaction = HibernateUtil.startTransactionIfAbsent(session);
            session.save(entity);
            if(transaction != null) transaction.commit();
            return entity;
        }catch (Exception e){
            logger.error("Exception during persisting " + entity, e);
            HibernateUtil.rollbackTxnIfAny();
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T extends AbstractEntity> T updateEntity(T entity){
        try {
            Session session = HibernateUtil.getCurrentSession();
            Transaction transaction = HibernateUtil.startTransactionIfAbsent(session);
            session.update(entity);
            if(transaction != null) transaction.commit();
            return entity;
        }catch (Exception e){
            HibernateUtil.rollbackTxnIfAny();
            logger.error("Exception during updating " + entity, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T extends AbstractEntity> T getEntityById(int id, Class<T> cls){
        try {
            Session session = HibernateUtil.getCurrentSession();
            Transaction transaction = HibernateUtil.startTransactionIfAbsent(session);
            T entity = session.get(cls, id);
            if(transaction != null) transaction.commit();
            return entity;
        }catch (Exception e){
            logger.error("Exception during fetching " + cls.getSimpleName(), e);
            HibernateUtil.rollbackTxnIfAny();
            throw new RuntimeException(e.getMessage());
        }
    }

    public static <T extends AbstractEntity> T queryEntityByShortname(String shortname, Class<T> cls){
        return queryEntityByAttribute("shortName", shortname, cls);
    }

    public static <T extends AbstractEntity> T queryEntityByAttribute(String attributeName, String attributeValue, Class<T> cls){
        try {
            Session session = HibernateUtil.getCurrentSession();
            Transaction transaction = HibernateUtil.startTransactionIfAbsent(session);
            String entityName = cls.getSimpleName();
            Query<T> query = session.createQuery("from " + entityName + " where " + attributeName + "=:value");
            query.setParameter("value", attributeValue);
            T entity = query.uniqueResult();

            if(transaction != null) transaction.commit();
            return entity;
        }catch (Exception e){
            HibernateUtil.rollbackTxnIfAny();
            logger.error("Exception during fetching " + cls.getSimpleName(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public static void populateDefaultValues(AbstractEntity... entityList){
        for(AbstractEntity entity : entityList) {
            if (entity == null) continue;
            if (entity.getStatus() == null) entity.setStatus("A");
            long time = System.currentTimeMillis();
            if (entity.getCreationTime() == 0) entity.setCreationTime(time);
            entity.setModificationTime(time);
        }
    }
}
