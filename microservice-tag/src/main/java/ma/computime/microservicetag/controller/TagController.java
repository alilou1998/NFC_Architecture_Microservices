package ma.computime.microservicetag.controller;

import ma.computime.microservicetag.bean.NewTagBean;
import ma.computime.microservicetag.bean.mDataBean;
import ma.computime.microservicetag.dao.TagDao;
import ma.computime.microservicetag.entities.Tag;
import ma.computime.microservicetag.exception.TagNotFoundException;
import ma.computime.microservicetag.proxy.MicroservicePersonneProxy;
import ma.computime.microservicetag.proxy.MicroserviceTagReaderProxy;
import ma.computime.microservicetag.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TagController {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    private final MicroserviceTagReaderProxy microserviceTagReaderProxy;
    private final MicroservicePersonneProxy microservicePersonneProxy;
    private final TagService tagService;
    private final TagDao tagDao;


    @Autowired
    public TagController(MicroserviceTagReaderProxy microserviceTagReaderProxy, MicroservicePersonneProxy microservicePersonneProxy, TagService nfcService, TagDao tagDao) {
        this.microserviceTagReaderProxy = microserviceTagReaderProxy;
        this.microservicePersonneProxy = microservicePersonneProxy;
        this.tagService = nfcService;
        this.tagDao = tagDao;
    }


    @GetMapping("/tags")
    public ResponseEntity<List<Tag>> listTag() {
        return ResponseEntity.ok(tagService.allTag());
    }


    @GetMapping("/tags/{uid}")
    public ResponseEntity<Tag> getTag(@PathVariable("uid") String s) {
        Tag tag = tagService.findParUid(s);
        if(tag.getPersonne_id()==0){
            return ResponseEntity.ok(tag);
        }
        int personne_id = tag.getPersonne_id();
        if(personne_id>0){
            if(microservicePersonneProxy.get(personne_id)!=null) {
                return ResponseEntity.ok(tagService.findParUid(s));
            }
        }
        return ResponseEntity.notFound().header("MyResponseHeader","Tag not found").build();

    }

    @PostMapping("/tags")
    public ResponseEntity<List<Tag>> addTag(@RequestBody List<mDataBean> listemDataBean){

        List<NewTagBean> listenewtagBean = microserviceTagReaderProxy.formatNewTag(listemDataBean);
        List<Tag> listeTag = new ArrayList<>();

        for(NewTagBean newtagBean:listenewtagBean){
            Tag tag = new Tag();
            if(microservicePersonneProxy.get(newtagBean.getPersonne_id())!=null){
                tag.setUid(newtagBean.getUid());
                tag.setPersonne_id(newtagBean.getPersonne_id());
            }
            listeTag.add(tag);
        }
        return ResponseEntity.ok(tagService.addListTag(listeTag));
    }

    @DeleteMapping("/tags/{uid}")
    public ResponseEntity<Void> deleteTag(@PathVariable("uid") String s) {
        tagService.deleteTag(s);
        return ResponseEntity.noContent().build();
    }

}
