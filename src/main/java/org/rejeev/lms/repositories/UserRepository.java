package org.rejeev.lms.repositories;

import jakarta.persistence.criteria.Join;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.*;
import org.rejeev.lms.hibernate.HibernateUtil;
import org.rejeev.lms.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class UserRepository extends AbstractRepository {
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
    public static User create(User user){
        setDefaultValues(user);
        return AbstractRepository.createEntity(user);
    }

    public static User update(User user){
        setDefaultValues(user);
        return AbstractRepository.updateEntity(user);
    }

    public static User getById(int id){
        return AbstractRepository.getEntityById(id, User.class);
    }

    public static User getByUserId(String userId){
        return AbstractRepository.queryEntityByAttribute("userId", userId, User.class);
    }

    public static List<User> findUsers(
            String firstName,
            String lastName,
            String email,
            String phone,
            String mobilePhone,
            String locality,
            String region,
            String country,
            String postCode
    ){
        try {
            Session session = HibernateUtil.getCurrentSession();
            Transaction transaction = HibernateUtil.startTransactionIfAbsent(session);
            HibernateCriteriaBuilder cb = session.getCriteriaBuilder();
            JpaCriteriaQuery<User> cq = cb.createQuery(User.class);
            JpaRoot<User> root = cq.from(User.class);
            boolean addressNeeded = locality != null || region != null || country != null || postCode != null;
            boolean contactNeeded = addressNeeded || email != null || phone != null || mobilePhone != null;
            logger.info("adderssNeeded=" + addressNeeded + ", contactNeeded=" + contactNeeded);
            List<JpaPredicate> predicates = new ArrayList<>();
            if(firstName != null) predicates.add(cb.like(root.get(User_.firstName), '%'+firstName+'%'));
            if(lastName != null) predicates.add(cb.like(root.get(User_.lastName), '%'+lastName+'%'));
            if(contactNeeded){
                Join<Object, Object> contact = root.join(User_.CONTACT_INFO);
                if(email != null) predicates.add(cb.equal(contact.get(ContactInfo_.EMAIL), email));
                if(phone != null) predicates.add(cb.equal(contact.get(ContactInfo_.PHONE), phone));
                if(mobilePhone != null) predicates.add(cb.equal(contact.get(ContactInfo_.MOBILE_PHONE), mobilePhone));
                if(addressNeeded){
                    Join<Object, Object> address = contact.join(ContactInfo_.ADDRESS);
                    if(region != null) predicates.add(cb.equal(address.get(Address_.REGION), region));
                    if(locality != null) predicates.add(cb.equal(address.get(Address_.LOCALITY), locality));
                    if(country != null) predicates.add(cb.equal(address.get(Address_.COUNTRY), country));
                    if(postCode != null) predicates.add(cb.equal(address.get(Address_.POST_CODE), postCode));
                }
            }
            if(predicates.isEmpty()){
                throw new RuntimeException();
            }
            JpaPredicate predicate = cb.and(predicates.toArray(new JpaPredicate[0]));
            cq.select(root).where(predicate);
            List<User> userList = session.createQuery(cq).getResultList();
            if(transaction != null) transaction.commit();
            return userList;
        }catch (Exception e){
            HibernateUtil.rollbackTxnIfAny();
            logger.error("Exception during executing query", e);
        }
        return null;
    }

    private static void setDefaultValues(User user){
        AbstractRepository.populateDefaultValues(user, user.getContactInfo());
        if(user.getContactInfo() != null) AbstractRepository.populateDefaultValues(user.getContactInfo().getAddress());
    }
}
