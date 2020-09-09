package ma.computime.microservicetagdateregister.service;

import ma.computime.microservicetagdateregister.dao.TagDateRegisterDao;
import ma.computime.microservicetagdateregister.entities.TagDateRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ServiceImpl implements TagDateRegisterService {

    private final TagDateRegisterDao tagDateRegisterDao;

    @Autowired
    public ServiceImpl(TagDateRegisterDao tagDateRegisterDao) {
        this.tagDateRegisterDao = tagDateRegisterDao;
    }

    @Override
    public List<TagDateRegister> getAll() {
        return tagDateRegisterDao.findAll();
    }

    @Override
    public TagDateRegister get(int id) {
        return tagDateRegisterDao.getOne(id);
    }

    @Override
    public TagDateRegister add(TagDateRegister tagDateRegister) {
        return tagDateRegisterDao.save(tagDateRegister);
    }

    @Override
    public List<TagDateRegister> addAll(List<TagDateRegister> tagDateRegisters) {
        return tagDateRegisterDao.saveAll(tagDateRegisters);
    }

    @Override
    public void delete(int id) {
        TagDateRegister tagDateRegister = get(id);
        tagDateRegisterDao.delete(tagDateRegister);
    }

    @Override
    public List<TagDateRegister> findAllBetween(Date checkin, Date checkout) {
        return tagDateRegisterDao.findAllByRegisterDateBetween(checkin,checkout);
    }


}
