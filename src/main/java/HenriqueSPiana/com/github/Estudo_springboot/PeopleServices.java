package HenriqueSPiana.com.github.Estudo_springboot;

import HenriqueSPiana.com.github.Estudo_springboot.model.People;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


@Service
public class PeopleServices {


    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PeopleServices.class.getName());

    public People findByID(String id){

        logger.info("Finding one Person!");


        People people = new People();
        people.setId(counter.incrementAndGet());
        people.setNome("Testonildo");
        people.setSobrenome("Da silva");
        people.setGenero("Homem");
        people.setEndereco("Vila velha");
        return people;
    }


}
