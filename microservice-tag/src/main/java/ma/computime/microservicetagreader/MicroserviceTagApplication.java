package ma.computime.microservicetagreader;

import ma.computime.microservicetagreader.dao.PersonneDao;
import ma.computime.microservicetagreader.dao.TagDao;
import ma.computime.microservicetagreader.entities.Personne;
import ma.computime.microservicetagreader.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableFeignClients("ma.computime.microservicetagreader")
public class MicroserviceTagApplication implements CommandLineRunner {


	private final TagDao tagDao;
	private final PersonneDao personneDao;

	@Autowired
	public MicroserviceTagApplication(TagDao tagDao, PersonneDao personneDao) {
		this.tagDao = tagDao;
		this.personneDao = personneDao;
	}


	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTagApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Personne personne = new Personne("ali","alaoui");
		personneDao.save(personne);
		Tag tag = new Tag("TAG-1",personne);
		tagDao.save(tag);
	}

}