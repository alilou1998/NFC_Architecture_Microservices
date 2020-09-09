package ma.computime.microservicetag.service;


import ma.computime.microservicetag.dao.TagDao;
import ma.computime.microservicetag.entities.Tag;
import ma.computime.microservicetag.exception.TagNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TagDao tagDao;

    @Autowired
    public TagServiceImpl(TagDao tagDao) {
        this.tagDao = tagDao;
    }


    @Override
    public Tag findParUid(String s) {
        if(tagDao.findByUid(s)!=null){
            return tagDao.findByUid(s);
        }
        return new Tag(String.format("Tag %s non trouve",s),0);
    }

    @Override
    public Tag addTag(Tag tag) {
        return tagDao.save(tag);
    }

    @Override
    public List<Tag> addListTag(List<Tag> list) {
        for (Tag tag : list) {
            addTag(tag);
        }
        return list;
    }

    @Override
    public List<Tag> allTag() {
        return tagDao.findAll();
    }

    @Override
    public void deleteTag(String s) {
        tagDao.deleteById(s);
    }


}
