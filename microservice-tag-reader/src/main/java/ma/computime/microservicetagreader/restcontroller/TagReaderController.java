package ma.computime.microservicetagreader.restcontroller;


import ma.computime.microservicetagreader.bean.NewTagBean;
import ma.computime.microservicetagreader.bean.TagBean;
import ma.computime.microservicetagreader.entities.mData;
import ma.computime.microservicetagreader.service.NFCServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@RestController
public class TagReaderController {


    private final NFCServiceImpl nfcService;


    @Autowired
    public TagReaderController(NFCServiceImpl nfcService) {
        this.nfcService = nfcService;
    }


    @PostMapping("/formattedTag")
    public List<TagBean> getFormattedTag(@RequestBody List<mData> listemdata) throws ParseException {
        List<TagBean> listTags = new ArrayList<>();
        for (mData m : listemdata) {
            List<String> strings = nfcService.tagFormat(m.getM());
            TagBean tag = new TagBean();
            tag.setUid(strings.get(0));
            String date = strings.get(1);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            dateFormat.setTimeZone(TimeZone.getTimeZone("UTC+1"));
            tag.setRegisterDate(dateFormat.parse(date));
            listTags.add(tag);
        }
        return listTags;
    }

    @PostMapping("/formatTag")
    public List<NewTagBean> formatNewTag(@RequestBody List<mData> list){
        List<NewTagBean> newTagBeans = new ArrayList<>();
        for(mData m:list){
            List<String> strings = nfcService.tagFormat(m.getM());
            NewTagBean newTagBean = new NewTagBean(strings.get(0),Integer.parseInt(strings.get(1)));
            newTagBeans.add(newTagBean);
        }
        return newTagBeans;
    }

}
