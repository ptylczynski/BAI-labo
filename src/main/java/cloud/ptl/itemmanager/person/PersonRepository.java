package cloud.ptl.itemmanager.person;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<PersonDAO, Long> {
}
