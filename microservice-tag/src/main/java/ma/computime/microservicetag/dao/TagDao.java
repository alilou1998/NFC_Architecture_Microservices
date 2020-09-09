package ma.computime.microservicetag.dao;

import ma.computime.microservicetag.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagDao extends JpaRepository<Tag, String> {

    Tag findByUid(@Param("x") String s);

    void deleteById(String s);
}
