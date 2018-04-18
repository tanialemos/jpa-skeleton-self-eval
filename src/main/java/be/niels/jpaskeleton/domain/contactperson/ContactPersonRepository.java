package be.niels.jpaskeleton.domain.contactperson;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ContactPersonRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ContactPerson save(ContactPerson contactPerson){
        entityManager.persist(contactPerson);
        return contactPerson;
    }

    public ContactPerson findById(int id){
        return entityManager.find(ContactPerson.class, id);
    }



}
