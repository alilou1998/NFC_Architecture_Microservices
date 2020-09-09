package ma.computime.microservicetag.service;


import ma.computime.microservicetag.entities.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {

//    List<String> tagFormat(String s);

    Tag findParUid(String s);

    Tag addTag(Tag tag);

    List<Tag> addListTag(List<Tag> list);

    List<Tag> allTag();

    void deleteTag(String s);

}
