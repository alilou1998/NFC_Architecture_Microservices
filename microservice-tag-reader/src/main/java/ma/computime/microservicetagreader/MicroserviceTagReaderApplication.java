package ma.computime.microservicetagreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("ma.computime.microservicetagreader")
public class MicroserviceTagReaderApplication {

//    private final TagDao tagDao;
//    private final PersonneDao personneDao;
//
//    @Autowired
//    public MicroserviceTagReaderApplication(TagDao tagDao, PersonneDao personneDao) {
//        this.tagDao = tagDao;
//        this.personneDao = personneDao;
//    }


    public static void main(String[] args) {
        SpringApplication.run(MicroserviceTagReaderApplication.class, args);
    }


//    @Override
//    public void run(String... args) throws Exception {
//        Personne personne = new Personne("ali","alaoui");
//        personneDao.save(personne);
//        Tag tag = new Tag("TAG-1",personne);
//        tagDao.save(tag);
//    }

}
