//package ma.computime.microservicetagreader.dao;
//
//import ma.computime.microservicetagreader.entities.Tag;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
//
//public interface TagDao extends JpaRepository<Tag, String> {
//
//    //    @Query("select tag from Tag tag where tag.uid=:x")
//    Tag findByUid(@Param("x") String s);
//
//    void deleteById(String s);
//}
