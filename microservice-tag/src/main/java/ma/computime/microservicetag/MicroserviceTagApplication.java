package ma.computime.microservicetag;

import ma.computime.microservicetag.bean.PersonneBean;
import ma.computime.microservicetag.dao.TagDao;
import ma.computime.microservicetag.entities.Tag;
import ma.computime.microservicetag.proxy.MicroservicePersonneProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients("ma.computime.microservicetag")
public class MicroserviceTagApplication implements CommandLineRunner {


	private final TagDao tagDao;
	private final MicroservicePersonneProxy microservicePersonneProxy;

	@Autowired
	public MicroserviceTagApplication(TagDao tagDao, MicroservicePersonneProxy microservicePersonneProxy) {
		this.tagDao = tagDao;
		this.microservicePersonneProxy = microservicePersonneProxy;
	}


	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTagApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Tag tag1 = new Tag("TAG-1",1);
		Tag tag2 = new Tag("TAG-2",2);
		Tag tag3 = new Tag("TAG-3",3);
		tagDao.save(tag1);
		tagDao.save(tag2);
		tagDao.save(tag3);
	}

}
