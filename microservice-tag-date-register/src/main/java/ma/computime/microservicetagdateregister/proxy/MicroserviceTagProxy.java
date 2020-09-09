package ma.computime.microservicetagdateregister.proxy;

import ma.computime.microservicetagdateregister.bean.TagBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "microservice-tag")
public interface MicroserviceTagProxy {

    @GetMapping("/tags/{uid}")
    ResponseEntity<TagBean> getTag(@PathVariable("uid") String s);
}
