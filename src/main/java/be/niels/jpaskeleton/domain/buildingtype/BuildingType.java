package be.niels.jpaskeleton.domain.buildingtype;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BUILDING_TYPES")
public class BuildingType {

    @Id
    @Column(name = "BUILDING_CODE")
    private String buildingCode;
    @Column(name = "BUILDING_TYPE")
    private String buildingType;

    public BuildingType() {
    }

    public BuildingType(String buildingCode, String buildingType) {
        this.buildingCode = buildingCode;
        this.buildingType = buildingType;
    }

    public String getBuildingCode() {
        return buildingCode;
    }

    public String getBuildingType() {
        return buildingType;
    }
}
