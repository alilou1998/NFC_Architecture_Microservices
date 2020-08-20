package ma.computime.microservicetag.controller;

import ma.computime.microservicetag.bean.TagBean;
import ma.computime.microservicetag.bean.mDataBean;
import ma.computime.microservicetag.dao.PersonneDao;
import ma.computime.microservicetag.entities.Personne;
import ma.computime.microservicetag.entities.Tag;
import ma.computime.microservicetag.proxy.MicroserviceTagReaderProxy;
import ma.computime.microservicetag.service.NFCService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TagController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    private final MicroserviceTagReaderProxy microserviceTagReaderProxy;
    private final NFCService nfcService;
    private final PersonneDao personneDao;

    @Autowired
    public TagController(MicroserviceTagReaderProxy microserviceTagReaderProxy, NFCService nfcService, PersonneDao personneDao) {
        this.microserviceTagReaderProxy = microserviceTagReaderProxy;
        this.nfcService = nfcService;
        this.personneDao = personneDao;
    }


    @GetMapping("/tags")
    public ResponseEntity<List<Tag>> listTag() {
        return ResponseEntity.ok(nfcService.allTag());
    }

    @GetMapping("/tags/{uid}")
    public ResponseEntity<Tag> getTag(@PathVariable("uid") String s) {
        return ResponseEntity.ok(nfcService.findParUid(s));
    }

    @PostMapping("/tags")
    public ResponseEntity<Tag> addTag(@RequestBody mDataBean mDataBean){
        TagBean tagBean = microserviceTagReaderProxy.getFormattedTag(mDataBean);
        Tag tag = new Tag();
        Personne personne;
        if(personneDao.getId(tagBean.getPersonne().getNom(),tagBean.getPersonne().getPrenom())==null){
            logger.info("Personne not found");
            personne = new Personne();
            personne.setNom(tagBean.getPersonne().getNom());
            personne.setPrenom(tagBean.getPersonne().getPrenom());
            personneDao.save(personne);
        }else{
            int id= personneDao.getId(tagBean.getPersonne().getNom(),tagBean.getPersonne().getPrenom());
            personne = personneDao.getOne(id);
            logger.info("Personne found :"+id+" "+personne.getNom()+" "+personne.getPrenom());
        }
        tag.setUid(tagBean.getUid());
        nfcService.addTag(tag);
        tag.setPersonne(personne);
        logger.info("Tag :"+tag.getUid()+" "+"Personne :"+tag.getPersonne().getPrenom()+" "+tag.getPersonne().getNom());
        return ResponseEntity.ok(nfcService.addTag(tag));
    }

    @DeleteMapping("/tags/{uid}")
    public ResponseEntity<Void> deleteTag(@PathVariable("uid") String s) {
        nfcService.deleteTag(s);
        return ResponseEntity.noContent().build();
    }

}
