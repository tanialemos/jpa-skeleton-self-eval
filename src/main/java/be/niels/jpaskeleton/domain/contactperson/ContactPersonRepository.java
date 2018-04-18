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


    public ContactPerson getByName(String lastName, String firstName) {
        return entityManager.createQuery("FROM ContactPerson p WHERE lastName = :lastName AND firstName = :firstName", ContactPerson.class)
                .setParameter("lastName", lastName)
                .setParameter("firstName", firstName)
                .getSingleResult();
    }
}
