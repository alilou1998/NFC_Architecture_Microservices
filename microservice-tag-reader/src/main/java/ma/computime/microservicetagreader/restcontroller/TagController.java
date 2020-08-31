package ma.computime.microservicetagreader.restcontroller;


import ma.computime.microservicetagreader.bean.PersonneBean;
import ma.computime.microservicetagreader.bean.TagBean;
import ma.computime.microservicetagreader.entities.mData;
import ma.computime.microservicetagreader.proxy.MicroservicetagreaderProxy;
import ma.computime.microservicetagreader.service.NFCServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@RestController
public class TagController {


    private final NFCServiceImpl nfcService;
    private final MicroservicetagreaderProxy microservicetagreaderProxy;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public TagController(NFCServiceImpl nfcService, MicroservicetagreaderProxy microservicetagreaderProxy) {
        this.nfcService = nfcService;
        this.microservicetagreaderProxy = microservicetagreaderProxy;
    }



    @PostMapping("/formattedTag")
    public List<TagBean> getFormattedTag(@RequestBody List<mData> listemdata) throws ParseException {
        List<PersonneBean> personneList = microservicetagreaderProxy.personneList();
        List<TagBean> listTags = new ArrayList<>();
        for(mData m:listemdata){
            List<String> strings = nfcService.tagFormat(m.getM());
            PersonneBean personne=new PersonneBean();
            TagBean tag = new TagBean();
            for(PersonneBean p : personneList){
                if(p.getNom().equals(strings.get(1)) && p.getPrenom().equals(strings.get(2))){
                    tag.setUid(strings.get(0));
                    String date = strings.get(3);
                    SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC+1"));
                    tag.setRegisterDate(dateFormat.parse(date));
                    personne.setNom(p.getNom());
                    personne.setPrenom(p.getPrenom());
                }else{
                    tag.setUid(strings.get(0));
                    String date = strings.get(3);
                    SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    dateFormat.setTimeZone(TimeZone.getTimeZone("UTC+1"));
                    tag.setRegisterDate(dateFormat.parse(date));
                    personne = new PersonneBean();
                    personne.setNom(strings.get(1).toUpperCase());
                    personne.setPrenom(strings.get(2).substring(0, 1).toUpperCase() + strings.get(2).substring(1));
                }
            }
            tag.setPersonne(personne);
            listTags.add(tag);
        }
        return listTags;
    }

}
