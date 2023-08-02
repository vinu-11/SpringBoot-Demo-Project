package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    @Autowired
    private final PersonService personService;
    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    @PostMapping                //For Post Get Understanding Use annotations
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) {
        return  personService.getPersonById(id)
                .orElse(null);
    }
}
