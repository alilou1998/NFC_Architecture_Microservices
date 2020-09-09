package ma.computime.microservicetagdateregister.dao;

import ma.computime.microservicetagdateregister.entities.TagDateRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TagDateRegisterDao extends JpaRepository<TagDateRegister,Integer> {

    List<TagDateRegister> findAllByRegisterDateBetween(Date checkin,Date checkout);

}
