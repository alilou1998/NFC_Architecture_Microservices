package ma.computime.microservicepersonne.service;

import ma.computime.microservicepersonne.entities.Personne;

import java.util.List;

public interface PersonneService {

    List<Personne> getAll();

    Personne addPersonne(Personne personne);

    Personne getPersonne(int id);

    void deletePersonne(int id);

}
