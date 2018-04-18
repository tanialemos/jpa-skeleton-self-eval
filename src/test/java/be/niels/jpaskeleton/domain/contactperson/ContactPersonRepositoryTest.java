package be.niels.jpaskeleton.domain.contactperson;

import be.niels.jpaskeleton.Application;
import be.niels.jpaskeleton.domain.address.Address;
import be.niels.jpaskeleton.domain.address.PostalCode;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ContactPersonRepositoryTest {

    @Autowired
    private ContactPersonRepository contactPersonRepository;

    @Test
    @Transactional
    public void save() {
        PostalCode pc = new PostalCode(1050, "Ixelles");
        Address address = new Address("Rue de la fatigue", "25", pc);

        ContactPerson cp = ContactPerson.ContactPersonBuilder.ContactPersonBuilder()
                .withFirstName("John")
                .withLastName("Smith")
                .withEmail("john.smith@gmail.com")
                .withMobilePhone("0487595653")
                .withAddress(address)
                .createContactPerson();

        ContactPerson savedCp = contactPersonRepository.save(cp);

        Assertions.assertThat(savedCp).isNotNull();
        Assertions.assertThat(savedCp.getContactPersonId()).isNotEqualTo(0);
    }

//    @Test
//    public void findById() {
//    }

    @Test
    @Transactional
    public void getByName_happyPath(){
        PostalCode pc = new PostalCode(1050, "Ixelles");
        Address address = new Address("Rue de la fatigue", "25", pc);

        ContactPerson cp = ContactPerson.ContactPersonBuilder.ContactPersonBuilder()
                .withFirstName("John")
                .withLastName("Smith")
                .withEmail("john.smith@gmail.com")
                .withMobilePhone("0487595653")
                .withAddress(address)
                .createContactPerson();

        ContactPerson savedCp = contactPersonRepository.save(cp);

        Assertions.assertThat(contactPersonRepository.getByName("Smith", "John")).isEqualTo(savedCp);
    }


}