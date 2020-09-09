package ma.computime.microservicepersonne.restcontroller;

import ma.computime.microservicepersonne.entities.Personne;
import ma.computime.microservicepersonne.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonneController {

    private final PersonneService personneService;

    @Autowired
    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping
    public List<Personne> getAll(){
        return personneService.getAll();
    }


    @GetMapping("/personnes/{id}")
    public Personne get(@PathVariable int id){
        return personneService.getPersonne(id);
    }

    @PostMapping("/personnes/add")
    public Personne add(@RequestBody Personne personne){
        return personneService.addPersonne(personne);
    }

    @DeleteMapping("/personnes/delete/{id}")
    public void delete(@PathVariable int id){
        personneService.deletePersonne(id);
    }

}
