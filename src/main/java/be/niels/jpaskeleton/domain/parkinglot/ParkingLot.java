package be.niels.jpaskeleton.domain.parkinglot;

import be.niels.jpaskeleton.domain.address.Address;
import be.niels.jpaskeleton.domain.buildingtype.BuildingType;
import be.niels.jpaskeleton.domain.contactperson.ContactPerson;
import be.niels.jpaskeleton.domain.division.Division;

import javax.persistence.*;

@Entity
@Table(name = "PARKING_LOTS")
public class ParkingLot {

    @Id
    @SequenceGenerator(name = "parkinglot_seq", sequenceName = "parkinglot_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parkinglot_seq")
    @Column(name = "PARKINGLOT_ID")
    private int parkingLotId;
    @Column(name = "NAME")
    private String name;
    @ManyToOne
    @JoinColumn(name = "DIVISION_ID")
    private Division division;
    @ManyToOne
    @JoinColumn(name="BUILDING_CODE")
    private BuildingType buildingType;
    @Column(name = "CAPACITY")
    private int capacity;
    @ManyToOne
    @JoinColumn(name = "CONTACTPERSON_ID")
    private ContactPerson contactPerson;
    @Embedded
    private Address address;
    @Column(name = "HOURLY_PRICE")
    private double hourlyPrice;

    private ParkingLot(String name, Division division, BuildingType buildingType, int capacity, ContactPerson contactPerson, Address address, double hourlyPrice) {
        this.name = name;
        this.division = division;
        this.buildingType = buildingType;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.hourlyPrice = hourlyPrice;
    }

    public static class ParkingLotBuilder {
        private String name;
        private Division division;
        private BuildingType buildingType;
        private int capacity;
        private ContactPerson contactPerson;
        private Address address;
        private double hourlyPrice;

        public String getName() {
            return name;
        }

        public Division getDivision() {
            return division;
        }

        public BuildingType getBuildingType() {
            return buildingType;
        }

        public int getCapacity() {
            return capacity;
        }

        public ContactPerson getContactPerson() {
            return contactPerson;
        }

        public Address getAddress() {
            return address;
        }

        public double getHourlyPrice() {
            return hourlyPrice;
        }

        public static ParkingLotBuilder parkingLotBuilder() {
            return new ParkingLotBuilder();
        }


        public ParkingLotBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ParkingLotBuilder withDivision(Division division) {
            this.division = division;
            return this;
        }

        public ParkingLotBuilder withBuildingType(BuildingType buildingType) {
            this.buildingType = buildingType;
            return this;
        }

        public ParkingLotBuilder withCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public ParkingLotBuilder withContactPerson(ContactPerson contactPerson) {
            this.contactPerson = contactPerson;
            return this;
        }

        public ParkingLotBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public ParkingLotBuilder withHourlyPrice(double hourlyPrice) {
            this.hourlyPrice = hourlyPrice;
            return this;
        }

        public ParkingLot createParkingLot() {
            return new ParkingLot(name, division, buildingType, capacity, contactPerson, address, hourlyPrice);
        }
    }
}
