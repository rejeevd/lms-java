package org.rejeev.lms.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.rejeev.lms.config.LmsConfigurations;
import org.rejeev.lms.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class HibernateUtil {
    private static final Logger log = LoggerFactory.getLogger(HibernateUtil.class);
    private static SessionFactory sessionFactory;
    private static SessionFactory buildSessionFactory() {
        try {
            log.info("Starting to create session factory");
            Configuration configuration = new Configuration();
            Properties props = new Properties();
            LmsConfigurations configs = LmsConfigurations.getInstance();
            props.put("hibernate.connection.driver_class", "org.postgresql.Driver");
            props.put("hibernate.connection.url", configs.getStringValue("database.url", "jdbc:postgresql://localhost:5432/lms"));
            props.put("hibernate.connection.username", configs.getStringValue("database.username", "postgres"));
            props.put("hibernate.connection.password", configs.getStringValue("database.password", ""));
            props.put("hibernate.current_session_context_class", "thread");
            props.put("hibernate.connection.pool_size", configs.getStringValue("hibernate.connection.pool.size", "10"));
            props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
            props.put("hibernate.cache.use_second_level_cache", false);
            props.put("hibernate.cache.use_query_cache", false);
            props.put("hibernate.show_sql", configs.getStringValue("hibernate.show.sql", "true"));
            //props.put("log4j.logger.org.hibernate.SQL", "debug");
            //props.put("log4j.logger.org.hibernate.type", "trace");
            configuration.setProperties(props);
            // v entities
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(ContactInfo.class);
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(BookEdition.class);
            configuration.addAnnotatedClass(BookInventory.class);
            configuration.addAnnotatedClass(User.class);
            configuration.addAnnotatedClass(Lease.class);
            configuration.addAnnotatedClass(Review.class);
            // ^ entities

            log.info("Hibernate Configuration loaded");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            log.info("Hibernate serviceRegistry created");
            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            return sessionFactory;
        }catch (Exception ex) {
            log.error("Initial SessionFactory creation failed." + ex);
            return null;
        }
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            synchronized (HibernateUtil.class) {
                if(sessionFactory == null) {
                    sessionFactory = buildSessionFactory();
                }
            }
        }
        return sessionFactory;
    }

    public static Session getCurrentSession(){
        return getSessionFactory().getCurrentSession();
    }
    public static Transaction startTransactionIfAbsent(Session session){
        if(!session.getTransaction().isActive()){
            return session.beginTransaction();
        }
        return null;
    }
    public static void rollbackTxnIfAny(){
        Transaction transaction = getCurrentSession().getTransaction();
        if(transaction.isActive()){
            transaction.rollback();
        }
    }
}
