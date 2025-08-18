package HenriqueSPiana.com.github.Estudo_springboot.controllers;
import HenriqueSPiana.com.github.Estudo_springboot.PersonServices;
import HenriqueSPiana.com.github.Estudo_springboot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;
    //http://localhost:8080/person/{id}
    @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findByid(@PathVariable("id") String id){
        Person personId = service.findByID(id);
        return personId;
    }


    //http://localhost:8080/person/{id}
    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        List<Person> personId = service.findAll();
        return personId;
    }

}
