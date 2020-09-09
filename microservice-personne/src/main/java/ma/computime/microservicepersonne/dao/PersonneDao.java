package ma.computime.microservicepersonne.dao;

import ma.computime.microservicepersonne.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneDao extends JpaRepository<Personne,Integer> {
}
