//package ma.computime.microservicetagreader.dao;
//
//import ma.computime.microservicetagreader.entities.Personne;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//public interface PersonneDao extends JpaRepository<Personne, Integer> {
//
//    Personne findByNomAndPrenom(String nom, String prenom);
//
//    @Query("select p.id from Personne p where p.nom=:x and p.prenom=:y")
//    Integer getId(@Param("x") String nom, @Param("y") String prenom);
//
//}
