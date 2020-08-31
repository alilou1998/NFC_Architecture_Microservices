package ma.computime.microservicetagreader.service;


import ma.computime.microservicetagreader.entities.Tag;

import java.util.List;

public interface NFCService {

//    List<String> tagFormat(String s);

    Tag findParUid(String s);

    Tag addTag(Tag tag);

    List<Tag> addListTag(List<Tag> list);

    List<Tag> allTag();

    void deleteTag(String s);

}
