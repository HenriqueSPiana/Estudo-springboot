package HenriqueSPiana.com.github.Estudo_springboot.controllers;


import HenriqueSPiana.com.github.Estudo_springboot.PeopleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {

    @Autowired
    private PeopleServices service;



}
