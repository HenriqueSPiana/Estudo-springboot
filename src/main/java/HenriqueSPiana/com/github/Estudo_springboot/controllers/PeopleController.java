package HenriqueSPiana.com.github.Estudo_springboot.controllers;


import HenriqueSPiana.com.github.Estudo_springboot.PeopleServices;
import HenriqueSPiana.com.github.Estudo_springboot.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PeopleController {

    @Autowired
    private PeopleServices service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public People findByid(@PathVariable("id") String id){
        People peopleId = service.findByID(id);
        return peopleId;
    }

}
