package ma.computime.microservicetagreader.proxy;

import ma.computime.microservicetagreader.bean.PersonneBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "microservice-tag")
@RibbonClient(value = "microservice-tag")
public interface MicroservicetagreaderProxy {

    @GetMapping("/personnes/")
    List<PersonneBean> personneList();

    @PostMapping("/personnes/addPersonne")
    PersonneBean addPersonne(@RequestBody PersonneBean personne);

}
