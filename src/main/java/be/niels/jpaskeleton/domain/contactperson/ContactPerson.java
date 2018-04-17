package be.niels.jpaskeleton.domain.contactperson;

import be.niels.jpaskeleton.domain.address.Address;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT_PERSONS")
public class ContactPerson {

    @Id
    @Column(name = "contactperson_id")
    @SequenceGenerator(name = "contactperson_seq", sequenceName = "contactperson_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contactperson_seq")
    private int contactPersonId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "fixed_name")
    private String fixedPhone;
    @Column(name = "email")
    private String email;
    @Embedded
    private Address address;

    public ContactPerson() {
    }

    ContactPerson(String firstName, String lastName, String mobilePhone, String fixedPhone, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.fixedPhone = fixedPhone;
        this.email = email;
        this.address = address;
    }

    public int getContactPersonId() {
        return contactPersonId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getFixedPhone() {
        return fixedPhone;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public static class ContactPersonBuilder {
        private String firstName;
        private String lastName;
        private String mobilePhone;
        private String fixedPhone;
        private String email;
        private Address address;

        public static ContactPersonBuilder ContactPersonBuilder() {
            return new ContactPersonBuilder();
        }

        public ContactPersonBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ContactPersonBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ContactPersonBuilder withMobilePhone(String mobilePhone) {
            this.mobilePhone = mobilePhone;
            return this;
        }

        public ContactPersonBuilder withFixedPhone(String fixedPhone) {
            this.fixedPhone = fixedPhone;
            return this;
        }

        public ContactPersonBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public ContactPersonBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public ContactPerson createContactPerson() {
            return new ContactPerson(firstName, lastName, mobilePhone, fixedPhone, email, address);
        }
    }
}
