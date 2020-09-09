package ma.computime.microservicepersonne;

import ma.computime.microservicepersonne.entities.Personne;
import ma.computime.microservicepersonne.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroservicepersonneApplication implements CommandLineRunner {

    private final PersonneService personneService;

    @Autowired
    public MicroservicepersonneApplication(PersonneService personneService) {
        this.personneService = personneService;
    }


    public static void main(String[] args) {
        SpringApplication.run(MicroservicepersonneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Personne personne1 = new Personne("alaoui","ali");
        Personne personne2 = new Personne("diouri","siham");
        Personne personne3 = new Personne("alaoui","hassan");

        personneService.addPersonne(personne1);
        personneService.addPersonne(personne2);
        personneService.addPersonne(personne3);
    }
}
