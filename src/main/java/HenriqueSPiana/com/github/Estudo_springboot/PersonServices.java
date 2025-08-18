package HenriqueSPiana.com.github.Estudo_springboot;

import HenriqueSPiana.com.github.Estudo_springboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


@Service
public class PersonServices {


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




    @org.jetbrains.annotations.NotNull
    private Person mockperson(int i) {


        logger.info("Finding one Person!");


        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setNome("Pessoa" + i );
        person.setSobrenome("Da silva"+ i );
        person.setGenero("Homem");
        person.setEndereco("Some adress in brazil");
        return person;


    }

}
