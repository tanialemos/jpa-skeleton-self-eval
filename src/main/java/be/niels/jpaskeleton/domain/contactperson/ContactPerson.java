package be.niels.jpaskeleton.domain.contactperson;

import be.niels.jpaskeleton.domain.address.Address;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT_PERSONS")
public class ContactPerson {

    private String contactPersonId;
    private String firstName;
    private String lastName;
    private String mobilePhone;
    private String fixedPhone;
    private String email;
    private Address address;

    public ContactPerson() {
    }

    ContactPerson(String contactPersonId, String firstName, String lastName, String mobilePhone, String fixedPhone, String email, Address address) {
        this.contactPersonId = contactPersonId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobilePhone = mobilePhone;
        this.fixedPhone = fixedPhone;
        this.email = email;
        this.address = address;
    }

    public String getContactPersonId() {
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
        private String contactPersonId;
        private String firstName;
        private String lastName;
        private String mobilePhone;
        private String fixedPhone;
        private String email;
        private Address address;

        public ContactPersonBuilder() {
        }

        public ContactPersonBuilder withContactPersonId(String contactPersonId) {
            this.contactPersonId = contactPersonId;
            return this;
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
            return new ContactPerson(contactPersonId, firstName, lastName, mobilePhone, fixedPhone, email, address);
        }
    }
}
