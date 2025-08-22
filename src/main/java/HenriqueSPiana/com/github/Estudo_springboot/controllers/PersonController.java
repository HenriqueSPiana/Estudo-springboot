package HenriqueSPiana.com.github.Estudo_springboot.controllers;
import HenriqueSPiana.com.github.Estudo_springboot.data.dto.PersonDTO;
import HenriqueSPiana.com.github.Estudo_springboot.services.PersonServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;
    //GET http://localhost:8080/person/{id}
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findByid(@PathVariable("id") Long id){
        PersonDTO personId = service.findByID(id);
        return personId;
    }


    //GET http://localhost:8080/person
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll(){
        List<PersonDTO> personId = service.findAll();
        return personId;
    }

    //POST http://localhost:8080/person
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO create(@RequestBody PersonDTO person){

        PersonDTO personId = service.create(person);
        return personId;
    }

    //PUT http://localhost:8080/person
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO update(@RequestBody PersonDTO person){
        PersonDTO personId = service.update(person);
        return personId;
    }


    //DELETE http://localhost:8080/person
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
