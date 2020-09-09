package ma.computime.microservicepersonne.service;

import ma.computime.microservicepersonne.dao.PersonneDao;
import ma.computime.microservicepersonne.entities.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonneServiceImpl implements PersonneService {

    private final PersonneDao personneDao;

    @Autowired
    public PersonneServiceImpl(PersonneDao personneDao) {
        this.personneDao = personneDao;
    }

    @Override
    public List<Personne> getAll() {
        return personneDao.findAll();
    }

    @Override
    public Personne addPersonne(Personne personne) {
        return personneDao.save(personne);
    }

    @Override
    public Personne getPersonne(int id) {
        return personneDao.getOne(id);
    }

    @Override
    public void deletePersonne(int id) {
        Personne personne = getPersonne(id);
        personneDao.delete(personne);
    }


}
