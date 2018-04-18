package be.niels.jpaskeleton.domain.buildingtype;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BuildingTypeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public BuildingType save(BuildingType buildingType){
        entityManager.persist(buildingType);
        return buildingType;
    }
}
