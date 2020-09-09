package ma.computime.microservicetagdateregister.service;

import ma.computime.microservicetagdateregister.entities.TagDateRegister;

import java.util.Date;
import java.util.List;

public interface TagDateRegisterService {

    List<TagDateRegister> getAll();

    TagDateRegister get(int id);

    TagDateRegister add(TagDateRegister tagDateRegister);

    List<TagDateRegister> addAll(List<TagDateRegister> tagDateRegisters);

    void delete(int id);

    List<TagDateRegister> findAllBetween(Date checkin, Date checkout);



}
