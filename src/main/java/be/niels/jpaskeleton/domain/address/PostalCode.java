package be.niels.jpaskeleton.domain.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "POSTALCODE")
public class PostalCode {

    @Id
    @Column(name = "POSTALCODE")
    private int postalCode;

    @Column(name = "POSTALCODE_LABEL")
    private String postalCodeLabel;

    public PostalCode() {
    }

    public PostalCode(int postalCode, String postalCodeLabel) {
        this.postalCode = postalCode;
        this.postalCodeLabel = postalCodeLabel;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getPostalCodeLabel() {
        return postalCodeLabel;
    }
}
