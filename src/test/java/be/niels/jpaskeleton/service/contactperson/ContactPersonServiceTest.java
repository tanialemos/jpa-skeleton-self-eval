package be.niels.jpaskeleton.service.contactperson;

import be.niels.jpaskeleton.Application;
import be.niels.jpaskeleton.domain.address.Address;
import be.niels.jpaskeleton.domain.address.PostalCode;
import be.niels.jpaskeleton.domain.contactperson.ContactPerson;
import be.niels.jpaskeleton.domain.contactperson.ContactPersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ContactPersonServiceTest {

    @Mock
    private ContactPersonRepository contactPersonRepository;
    @Autowired
    @InjectMocks
    private ContactPersonService contactPersonService;

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

        when(contactPersonRepository.save(cp)).thenReturn(cp);

        contactPersonService.save(cp);

        Assertions.assertThat(contactPersonService.save(cp)).isEqualTo(cp);
    }

    @Test
    @Transactional
    public void getByName() {
        PostalCode pc = new PostalCode(1050, "Ixelles");
        Address address = new Address("Rue de la fatigue", "25", pc);

        ContactPerson cp = ContactPerson.ContactPersonBuilder.ContactPersonBuilder()
                .withFirstName("John")
                .withLastName("Smith")
                .withEmail("john.smith@gmail.com")
                .withMobilePhone("0487595653")
                .withAddress(address)
                .createContactPerson();

        when(contactPersonRepository.getByName("Smith", "John")).thenReturn(cp);

        contactPersonService.save(cp);

        Assertions.assertThat(contactPersonService.getByName("Smith", "John")).isEqualTo(cp);
    }
}