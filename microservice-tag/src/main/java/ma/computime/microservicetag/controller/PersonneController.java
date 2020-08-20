package ma.computime.microservicetag.controller;

import ma.computime.microservicetag.dao.PersonneDao;
import ma.computime.microservicetag.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personnes")
public class PersonneController {


    private final PersonneDao personneDao;

    @Autowired
    public PersonneController(PersonneDao personneDao) {
        this.personneDao = personneDao;
    }

    @GetMapping("/")
    public List<Personne> personneList(){
        return personneDao.findAll();
    }

    @GetMapping("/{id}")
    public Personne personne(@PathVariable("id") int id){
        return personneDao.getOne(id);
    }

    @PostMapping("/addPersonne")
    public Personne addPersonne(@RequestBody Personne personne){
        return personneDao.save(personne);
    }

}
