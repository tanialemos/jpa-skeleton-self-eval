package be.niels.jpaskeleton.service.parkinglot;

import be.niels.jpaskeleton.domain.buildingtype.BuildingType;
import be.niels.jpaskeleton.domain.buildingtype.BuildingTypeRepository;
import be.niels.jpaskeleton.domain.contactperson.ContactPersonRepository;
import be.niels.jpaskeleton.domain.division.Division;
import be.niels.jpaskeleton.domain.division.DivisionRepository;
import be.niels.jpaskeleton.domain.parkinglot.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ParkingLotService {

    private ParkingLotRepository parkingLotRepository;
    private DivisionRepository divisionRepository;
    private BuildingTypeRepository buildingTypeRepository;
    private ContactPersonRepository contactPersonRepository;

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }


}
