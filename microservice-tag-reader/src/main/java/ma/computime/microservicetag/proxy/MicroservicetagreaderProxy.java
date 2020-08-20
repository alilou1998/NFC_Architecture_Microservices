package ma.computime.microservicetag.proxy;

import ma.computime.microservicetag.bean.PersonneBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "microservice-tag",url = "localhost:8184/personnes")
public interface MicroservicetagreaderProxy {

    @GetMapping("/")
    List<PersonneBean> personneList();

    @PostMapping("/addPersonne")
    PersonneBean addPersonne(@RequestBody PersonneBean personne);

}
