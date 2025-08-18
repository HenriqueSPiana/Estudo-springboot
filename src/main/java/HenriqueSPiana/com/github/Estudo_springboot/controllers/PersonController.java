package HenriqueSPiana.com.github.Estudo_springboot.controllers;
import HenriqueSPiana.com.github.Estudo_springboot.services.PersonServices;
import HenriqueSPiana.com.github.Estudo_springboot.model.Person;
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
    public Person findByid(@PathVariable("id") Long id){
        Person personId = service.findByID(id);
        return personId;
    }


    //GET http://localhost:8080/person
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        List<Person> personId = service.findAll();
        return personId;
    }

    //POST http://localhost:8080/person
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person){

       Person personId = service.create(person);
        return personId;
    }

    //PUT http://localhost:8080/person
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person){
       Person personId = service.update(person);
        return personId;
    }


    //DELETE http://localhost:8080/person
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
