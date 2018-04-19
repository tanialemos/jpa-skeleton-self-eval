package be.niels.jpaskeleton.service.contactperson;

import be.niels.jpaskeleton.domain.address.Address;
import be.niels.jpaskeleton.domain.address.PostalCode;
import be.niels.jpaskeleton.domain.contactperson.ContactPerson;
import be.niels.jpaskeleton.domain.contactperson.ContactPersonRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ContactPersonServiceTest {

    @Mock
    private ContactPersonRepository contactPersonRepository;
    @InjectMocks
    private ContactPersonService contactPersonService;

    @Test
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

        verify(contactPersonRepository, times(1)).save(cp);
        Assertions.assertThat(contactPersonService.save(cp)).isEqualTo(cp);
    }

    @Test
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