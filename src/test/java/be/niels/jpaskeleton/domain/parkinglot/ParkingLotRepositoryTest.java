package be.niels.jpaskeleton.domain.parkinglot;

import be.niels.jpaskeleton.Application;
import be.niels.jpaskeleton.domain.address.Address;
import be.niels.jpaskeleton.domain.address.PostalCode;
import be.niels.jpaskeleton.domain.buildingtype.BuildingType;
import be.niels.jpaskeleton.domain.buildingtype.BuildingTypeRepository;
import be.niels.jpaskeleton.domain.contactperson.ContactPerson;
import be.niels.jpaskeleton.domain.division.Division;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@EntityScan(basePackages = "be.niels.jpaskeleton")
public class ParkingLotRepositoryTest {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Test
    @Transactional
    public void save() {
        ParkingLot pl = ParkingLot.ParkingLotBuilder.parkingLotBuilder()
                .withName("Test Parking Lot")
                .withDivision(new Division())
                .withBuildingType(new BuildingType())
                .withAddress(new Address())
                .withCapacity(100)
                .withHourlyPrice(1.5)
                .withContactPerson(new ContactPerson())
                .createParkingLot();

        ParkingLot savedPl = parkingLotRepository.save(pl);

        Assertions.assertThat(savedPl).isNotNull();
        Assertions.assertThat(savedPl.getParkingLotId()).isNotZero();

    }
}