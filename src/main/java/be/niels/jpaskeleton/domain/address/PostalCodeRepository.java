package be.niels.jpaskeleton.domain.address;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PostalCodeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public PostalCode savePostalCode(PostalCode postalCode){
        entityManager.persist(postalCode);
        return postalCode;
    }

    public PostalCode findPostalCode(int id){
        return entityManager.find(PostalCode.class, id);
    }

}
