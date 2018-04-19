package be.niels.jpaskeleton.api.parkinglot;

import be.niels.jpaskeleton.service.parkinglot.ParkingLotService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@RestController
@RequestMapping(path = "/parkinglot")
public class ParkingLotController {

    private ParkingLotService parkingLotService;
    private ParkingLotMapper parkingLotMapper;

    @Inject
    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotMapper parkingLotMapper) {
        this.parkingLotService = parkingLotService;
        this.parkingLotMapper = parkingLotMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotDto save(@RequestBody ParkingLotDto parkingLotDto){
        return parkingLotMapper.mapToDto(parkingLotService.save(parkingLotMapper.mapToDomain(parkingLotDto)));
    }
}
