package ma.computime.microservicetagreader.controller;

import ma.computime.microservicetagreader.dao.PersonneDao;
import ma.computime.microservicetagreader.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonneController {


    private final PersonneDao personneDao;

    @Autowired
    public PersonneController(PersonneDao personneDao) {
        this.personneDao = personneDao;
    }

    @GetMapping("/personnes/")
    public List<Personne> personneList(){
        return personneDao.findAll();
    }

    @GetMapping("/personnes/{id}")
    public Personne personne(@PathVariable("id") int id){
        return personneDao.getOne(id);
    }

    @PostMapping("/personnes/addPersonne")
    public Personne addPersonne(@RequestBody Personne personne){
        return personneDao.save(personne);
    }

}
