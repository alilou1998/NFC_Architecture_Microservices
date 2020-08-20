package ma.computime.microservicetag.service;


import ma.computime.microservicetag.entities.Tag;

import java.util.List;

public interface NFCService {

//    List<String> tagFormat(String s);

    Tag findParUid(String s);

    Tag addTag(Tag tag);

    List<Tag> allTag();

    void deleteTag(String s);

}
