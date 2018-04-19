package be.niels.jpaskeleton.service.contactperson;

import be.niels.jpaskeleton.domain.contactperson.ContactPerson;
import be.niels.jpaskeleton.domain.contactperson.ContactPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ContactPersonService {

    private ContactPersonRepository contactPersonRepository;

    @Autowired
    public ContactPersonService(ContactPersonRepository contactPersonRepository) {
        this.contactPersonRepository = contactPersonRepository;
    }

    public ContactPerson save(ContactPerson contactPerson){
        return contactPersonRepository.save(contactPerson);
    }

    public ContactPerson getByName(String lastName, String firstName){
        return contactPersonRepository.getByName(lastName, firstName);
    }
}
