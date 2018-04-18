package be.niels.jpaskeleton.domain.division;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

@Repository
@Table(name = "DIVISIONS")
public class DivisionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Division save(Division division){
        entityManager.persist(division);
        return division;
    }

}
