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


@Service
public class PersonServices {

    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonDTO> findAll(){
        List<PersonDTO> persons = parseListObjects(repository.findAll(),PersonDTO.class);
        persons.forEach(this::addHateoasLink);
        return persons;
    }

    public PersonDTO findByID(Long id){
        logger.info("Finding one Person!");
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
        PersonDTO dto = parseObject(entity,PersonDTO.class);
        addHateoasLink(dto);
        return dto;


    }

    public PersonDTO create(PersonDTO person){
        logger.info("Creating one person");
        var entity = parseObject(person,Person.class);
        PersonDTO dto = parseObject(repository.save(entity),PersonDTO.class);
        addHateoasLink(dto);
        return dto;
    }

    public PersonDTO update(PersonDTO person){

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

        entity.setNome(person.getNome());
        entity.setSobrenome(person.getSobrenome());
        entity.setGenero(person.getGenero());
        entity.setEndereco(person.getEndereco());

        PersonDTO dto = parseObject(repository.save(entity),PersonDTO.class);
        addHateoasLink(dto);
        return dto;
    }

    public void delete(Long id){

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
        logger.info("deleting one person");
        repository.delete(entity);

    }




    private void addHateoasLink(PersonDTO dto) {
        dto.add(linkTo(methodOn(PersonController.class).findByid(dto.getId())).withSelfRel().withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).delete(dto.getId())).withRel("delete").withType("DELETE"));
        dto.add(linkTo(methodOn(PersonController.class).findAll()).withRel("findAll").withType("GET"));
        dto.add(linkTo(methodOn(PersonController.class).create(dto)).withRel("create").withType("POST"));
        dto.add(linkTo(methodOn(PersonController.class).update(dto)).withRel("update").withType("PUT"));
    }
}
