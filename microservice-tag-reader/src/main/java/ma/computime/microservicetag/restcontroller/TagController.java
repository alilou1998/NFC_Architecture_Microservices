package ma.computime.microservicetag.restcontroller;


import ma.computime.microservicetag.bean.PersonneBean;
import ma.computime.microservicetag.bean.TagBean;
import ma.computime.microservicetag.entities.mData;
import ma.computime.microservicetag.proxy.MicroservicetagreaderProxy;
import ma.computime.microservicetag.service.NFCServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TagController {


    private final NFCServiceImpl nfcService;
    private final MicroservicetagreaderProxy microservicetagreaderProxy;
//    private final PersonneDao personneDao;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public TagController(NFCServiceImpl nfcService, MicroservicetagreaderProxy microservicetagreaderProxy) {
        this.nfcService = nfcService;
        this.microservicetagreaderProxy = microservicetagreaderProxy;
    }

//    @GetMapping("/tags")
//    public ResponseEntity<List<Tag>> listTag() {
//        return ResponseEntity.ok(nfcService.allTag());
//    }
//
//    @GetMapping("/tags/{uid}")
//    public ResponseEntity<Tag> getTag(@PathVariable("uid") String s) {
//        return ResponseEntity.ok(nfcService.findParUid(s));
//    }



    @PostMapping("/formattedTag")
    public TagBean getFormattedTag(@RequestBody mData mdata){

        List<PersonneBean> personneList = microservicetagreaderProxy.personneList();
        List<String> strings = nfcService.tagFormat(mdata.getM());
        PersonneBean personne=new PersonneBean();
        int id;
        TagBean tag = new TagBean();
        for(PersonneBean p : personneList){
            if(p.getNom().equals(strings.get(1)) && p.getPrenom().equals(strings.get(2))){
                tag.setUid(strings.get(0));
                personne.setNom(p.getNom());
                personne.setPrenom(p.getPrenom());
            }else{
                tag.setUid(strings.get(0));
                personne = new PersonneBean();
                personne.setNom(strings.get(1).toUpperCase());
                personne.setPrenom(strings.get(2).substring(0, 1).toUpperCase() + strings.get(2).substring(1));
                //microservicetagreaderProxy.addPersonne(personne);
                logger.info("ADD "+personne.getPrenom()+" "+personne.getNom());
            }
        }
//        if (personneDao.findByNomAndPrenom(strings.get(1), strings.get(2)) != null) {
//            id = personneDao.getId(strings.get(1), strings.get(2));
//            tag.setUid(strings.get(0));
//            personne = personneDao.getOne(id);
//        } else {
//            personne = new Personne();
//            personne.setNom(strings.get(1).toUpperCase());
//            personne.setPrenom(strings.get(2).substring(0, 1).toUpperCase() + strings.get(2).substring(1));
//            personneDao.save(personne);
//            tag.setUid(strings.get(0));
//        }
        tag.setPersonne(personne);
        return tag;
    }

//    @PostMapping("/tags")
//    public ResponseEntity<Tag> addTag(@RequestBody mData mdata) {
//        logger.info(mdata.getM());
//        List<String> strings = nfcService.tagFormat(mdata.getM());
//        Personne personne;
//        Integer id;
//        Tag tag = new Tag();
//        if (personneDao.findByNomAndPrenom(strings.get(1), strings.get(2)) != null) {
//            id = personneDao.getId(strings.get(1), strings.get(2));
//            tag.setUid(strings.get(0));
//            personne = personneDao.getOne(id);
//        } else {
//            personne = new Personne();
//            personne.setNom(strings.get(1).toUpperCase());
//            personne.setPrenom(strings.get(2).substring(0, 1).toUpperCase() + strings.get(2).substring(1));
//            personneDao.save(personne);
//            tag.setUid(strings.get(0));
//        }
//        tag.setPersonne(personne);
//
//        return ResponseEntity.ok(nfcService.addTag(tag));
//    }

//    @DeleteMapping("/tags/{uid}")
//    public ResponseEntity<Void> deleteTag(@PathVariable("uid") String s) {
//        nfcService.deleteTag(s);
//        return ResponseEntity.noContent().build();
//    }

}
