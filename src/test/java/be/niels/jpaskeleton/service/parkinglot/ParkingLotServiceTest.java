package be.niels.jpaskeleton.service.parkinglot;

import be.niels.jpaskeleton.Application;
import be.niels.jpaskeleton.domain.address.Address;
import be.niels.jpaskeleton.domain.buildingtype.BuildingType;
import be.niels.jpaskeleton.domain.contactperson.ContactPerson;
import be.niels.jpaskeleton.domain.division.Division;
import be.niels.jpaskeleton.domain.parkinglot.ParkingLot;
import be.niels.jpaskeleton.domain.parkinglot.ParkingLotRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotServiceTest {

    @Mock
    private ParkingLotRepository parkingLotRepository;
    @InjectMocks
    private ParkingLotService parkingLotService;

    @Test
    public void save_happyPath() {
        ParkingLot pl = ParkingLot.ParkingLotBuilder.parkingLotBuilder()
                .withName("Test Parking Lot")
                .withDivision(new Division())
                .withBuildingType(new BuildingType())
                .withAddress(new Address())
                .withCapacity(100)
                .withHourlyPrice(1.5)
                .withContactPerson(new ContactPerson())
                .createParkingLot();

        when(parkingLotRepository.save(pl)).thenReturn(pl);

        Assertions.assertThat(parkingLotService.save(pl)).isEqualTo(pl);
        verify(parkingLotRepository, times(1)).save(pl);
    }
}