package be.niels.jpaskeleton.api.parkinglot;

import be.niels.jpaskeleton.domain.buildingtype.BuildingType;
import be.niels.jpaskeleton.domain.contactperson.ContactPerson;
import be.niels.jpaskeleton.domain.division.Division;
import be.niels.jpaskeleton.domain.parkinglot.ParkingLot;
import be.niels.jpaskeleton.service.contactperson.ContactPersonService;
import be.niels.jpaskeleton.service.division.DivisionService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ParkingLotMapper {

    private DivisionService divisionService;
    private ContactPersonService contactPersonService;

    @Inject
    public ParkingLotMapper(DivisionService divisionService, ContactPersonService contactPersonService) {
        this.divisionService = divisionService;
        this.contactPersonService = contactPersonService;
    }

    public ParkingLotDto mapToDto(ParkingLot parkingLot){
        return ParkingLotDto.ParkingLotDtoBuilder.parkingLotDtoBuilder()
                .withName(parkingLot.getName())
                .withDivision(parkingLot.getDivision().getName())
              //  .withAddress(parkingLot.getAddress().toString)
                .withBuildingType(parkingLot.getBuildingType().getBuildingCode())
                .withCapacity(parkingLot.getCapacity())
                .withContactPerson_firstName(parkingLot.getContactPerson().getFirstName())
                .withContactPerson_lastName(parkingLot.getContactPerson().getLastName())
                .withHourlyPrice(parkingLot.getHourlyPrice())
                .withParkingLotId(parkingLot.getParkingLotId())
                .createParkingLotDto();
    }

    public ParkingLot mapToDomain(ParkingLotDto parkingLotDto){
        return ParkingLot.ParkingLotBuilder.parkingLotBuilder()
                .withName(parkingLotDto.getName())
                .withDivision(getDivisionByName(parkingLotDto))
              //  .withAddress()
             //   .withBuildingType(getBuildingTypeById(parkingLotDto))
                .withCapacity(parkingLotDto.getCapacity())
                .withContactPerson(getContactPersonByName(parkingLotDto))
                .withHourlyPrice(parkingLotDto.getHourlyPrice())
                .createParkingLot();
    }

    private ContactPerson getContactPersonByName(ParkingLotDto parkingLotDto) {
        return contactPersonService.getByName(
                parkingLotDto.getContactPerson_lastName(),
                parkingLotDto.getContactPerson_firstName());
    }

//    private BuildingType getBuildingTypeById(ParkingLotDto parkingLotDto) {
//    }

    private Division getDivisionByName(ParkingLotDto parkingLotDto) {
        return divisionService.getByName(parkingLotDto.getDivision());
    }
}
