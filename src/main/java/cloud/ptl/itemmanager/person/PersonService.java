package cloud.ptl.itemmanager.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    private PersonDAO create(PersonDAO personDAO){
        return this.personRepository.save(personDAO);
    }

    public PersonDAO createIfNotExist(PersonDAO personDAO){
        if(this.personRepository.existsById(personDAO.getId()))
            return personDAO;
        else
            return this.create(personDAO);
    }

    public PersonDAO updateOne(PersonDAO personDAO){
        return this.personRepository.save(personDAO);
    }

    public void deleteOne(PersonDAO personDAO){
        this.personRepository.delete(personDAO);
    }

    public PersonDAO findOne(Long id) throws Exception {
        Optional<PersonDAO> optionalPersonDAO =
                this.personRepository.findById(id);
        if(optionalPersonDAO.isEmpty())
            throw new Exception("Person does not exist");
        else
            return optionalPersonDAO.get();
    }
}
