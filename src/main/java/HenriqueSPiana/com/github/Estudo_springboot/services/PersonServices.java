package HenriqueSPiana.com.github.Estudo_springboot.services;
import HenriqueSPiana.com.github.Estudo_springboot.exception.ResourceNotFoundException;
import HenriqueSPiana.com.github.Estudo_springboot.model.Person;
import HenriqueSPiana.com.github.Estudo_springboot.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class PersonServices {


    private static final org.slf4j.Logger log = LoggerFactory.getLogger(PersonServices.class);
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        List<Person> persons = repository.findAll();
        return persons;
    }

    public Person findByID(Long id){

        logger.info("Finding one Person!");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
    }

    public Person create(Person person){
        logger.info("Creating one person");
        repository.save(person);
        return person;
    }

    public Person update(Person person){

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setGenero(person.getGenero());
        entity.setEndereco(person.getEndereco());

        repository.save(person);
        return person;
    }

    public void delete(Long id){

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
        logger.info("deleting one person");
        repository.delete(entity);

    }

}
