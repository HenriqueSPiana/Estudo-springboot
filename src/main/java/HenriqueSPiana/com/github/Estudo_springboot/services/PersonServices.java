package HenriqueSPiana.com.github.Estudo_springboot.services;
import HenriqueSPiana.com.github.Estudo_springboot.controllers.PersonController;
import HenriqueSPiana.com.github.Estudo_springboot.data.dto.PersonDTO;
import HenriqueSPiana.com.github.Estudo_springboot.exception.ResourceNotFoundException;
import HenriqueSPiana.com.github.Estudo_springboot.mapper.ObjectMapper;
import static HenriqueSPiana.com.github.Estudo_springboot.mapper.ObjectMapper.parseListObjects;
import static HenriqueSPiana.com.github.Estudo_springboot.mapper.ObjectMapper.parseObject;

import HenriqueSPiana.com.github.Estudo_springboot.model.Person;
import HenriqueSPiana.com.github.Estudo_springboot.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

    public List<PersonDTO> findAll(){
        List<PersonDTO> persons = parseListObjects(repository.findAll(),PersonDTO.class);
        return persons;
    }

    public PersonDTO findByID(Long id){
        logger.info("Finding one Person!");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
        PersonDTO person = parseObject(entity,PersonDTO.class);

        person.add(linkTo(methodOn(PersonController.class).findByid(id)).withSelfRel().withType("GET"));
        return person;


    }

    public PersonDTO create(PersonDTO person){
        logger.info("Creating one person");
        var entity = parseObject(person,Person.class);
        PersonDTO savedPerson = parseObject(repository.save(entity),PersonDTO.class);
        return savedPerson;
    }

    public PersonDTO update(PersonDTO person){

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setGenero(person.getGenero());
        entity.setEndereco(person.getEndereco());

        PersonDTO updatedPerson = parseObject(repository.save(entity),PersonDTO.class);
        return updatedPerson;
    }

    public void delete(Long id){

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
        logger.info("deleting one person");
        repository.delete(entity);

    }

}
