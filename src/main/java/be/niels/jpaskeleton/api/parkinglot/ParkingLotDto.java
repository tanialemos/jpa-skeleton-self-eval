package be.niels.jpaskeleton.api.parkinglot;

public class ParkingLotDto {

    private int parkingLotId;
    private String name;
    private String division;
    private String buildingType;
    private int capacity;
    private String contactPerson_firstName;
    private String contactPerson_lastName;
    private String address;
    private double hourlyPrice;

    public ParkingLotDto() {
    }

    ParkingLotDto(int parkingLotId, String name, String division, String buildingType, int capacity, String contactPerson_firstName, String contactPerson_lastName, String address, double hourlyPrice) {
        this.parkingLotId = parkingLotId;
        this.name = name;
        this.division = division;
        this.buildingType = buildingType;
        this.capacity = capacity;
        this.contactPerson_firstName = contactPerson_firstName;
        this.contactPerson_lastName = contactPerson_lastName;
        this.address = address;
        this.hourlyPrice = hourlyPrice;
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public String getName() {
        return name;
    }

    public String getDivision() {
        return division;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getContactPerson_firstName() {
        return contactPerson_firstName;
    }

    public String getContactPerson_lastName() {
        return contactPerson_lastName;
    }

    public String getAddress() {
        return address;
    }

    public double getHourlyPrice() {
        return hourlyPrice;
    }


    public static class ParkingLotDtoBuilder {
        private int parkingLotId;
        private String name;
        private String division;
        private String buildingType;
        private int capacity;
        private String contactPerson_firstName;
        private String contactPerson_lastName;
        private String address;
        private double hourlyPrice;

        public static ParkingLotDtoBuilder parkingLotDtoBuilder(){
            return new ParkingLotDtoBuilder();
        }

        public ParkingLotDtoBuilder withParkingLotId(int parkingLotId) {
            this.parkingLotId = parkingLotId;
            return this;
        }

        public ParkingLotDtoBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ParkingLotDtoBuilder withDivision(String division) {
            this.division = division;
            return this;
        }

        public ParkingLotDtoBuilder withBuildingType(String buildingType) {
            this.buildingType = buildingType;
            return this;
        }

        public ParkingLotDtoBuilder withCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public ParkingLotDtoBuilder withContactPerson_firstName(String contactPerson_firstName) {
            this.contactPerson_firstName = contactPerson_firstName;
            return this;
        }

        public ParkingLotDtoBuilder withContactPerson_lastName(String contactPerson_lastName) {
            this.contactPerson_lastName = contactPerson_lastName;
            return this;
        }

        public ParkingLotDtoBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public ParkingLotDtoBuilder withHourlyPrice(double hourlyPrice) {
            this.hourlyPrice = hourlyPrice;
            return this;
        }

        public ParkingLotDto createParkingLotDto() {
            return new ParkingLotDto(parkingLotId, name, division, buildingType, capacity, contactPerson_firstName, contactPerson_lastName, address, hourlyPrice);
        }

    }
}
