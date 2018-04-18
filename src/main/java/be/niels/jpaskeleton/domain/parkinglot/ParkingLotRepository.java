package be.niels.jpaskeleton.domain.parkinglot;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ParkingLotRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ParkingLot save(ParkingLot parkingLot){
        entityManager.persist(parkingLot);
        return parkingLot;
    }
}
