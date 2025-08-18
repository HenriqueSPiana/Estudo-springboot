package HenriqueSPiana.com.github.Estudo_springboot.services;

import HenriqueSPiana.com.github.Estudo_springboot.model.Person;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


@Service
public class PersonServices {


    private static final org.slf4j.Logger log = LoggerFactory.getLogger(PersonServices.class);
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());




    public List<Person> findAll(){
        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i<8; i++){
            Person person = mockperson(i);
            persons.add(person);
        }
        return persons;
    }



    public Person findByID(String id){

        logger.info("Finding one Person!");


        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setNome("Testonildo");
        person.setSobrenome("Da silva");
        person.setGenero("Homem");
        person.setEndereco("Vila velha");
        return person;
    }

    public Person create(Person person){
        logger.info("Creating one person");
        return person;
    }

    public Person update(Person person){
        logger.info("updating one person");
        return person;
    }

    public void delete(String i){
        logger.info("deleting one person");
    }


    @org.jetbrains.annotations.NotNull
    private Person mockperson(int i) {


        logger.info("Finding All Person!");


        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setNome("Pessoa" + i );
        person.setSobrenome("Da silva"+ i );
        person.setGenero("Homem");
        person.setEndereco("Some adress in brazil");
        return person;


    }

}
