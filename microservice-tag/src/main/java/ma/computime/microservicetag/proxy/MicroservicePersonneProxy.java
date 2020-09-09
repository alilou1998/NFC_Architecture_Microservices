package ma.computime.microservicetag.proxy;

import ma.computime.microservicetag.bean.PersonneBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "microservice-personne")
@RibbonClient(value = "microservice-personne" )
public interface MicroservicePersonneProxy {

    @GetMapping("/personnes/{id}")
    PersonneBean get(@PathVariable int id);

}
