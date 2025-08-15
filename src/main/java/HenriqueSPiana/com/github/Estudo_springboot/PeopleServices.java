package HenriqueSPiana.com.github.Estudo_springboot;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;


@Service
public class PeopleServices {


    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PeopleServices.class.getName());

    public People findByID(String id){

        logger.info("Finding one Person!");

    }


}
