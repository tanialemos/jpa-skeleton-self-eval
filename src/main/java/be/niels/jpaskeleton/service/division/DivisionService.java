package be.niels.jpaskeleton.service.division;

import be.niels.jpaskeleton.domain.division.Division;
import be.niels.jpaskeleton.domain.division.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DivisionService {

    private DivisionRepository divisionRepository;

    @Autowired
    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public Division save(Division division){
        return divisionRepository.save(division);
    }

    public Division getById(int id){
        return divisionRepository.getById(id);
    }

    public Division getByName(String name) {
        return divisionRepository.getByName(name);
    }
}
