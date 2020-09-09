package ma.computime.microservicetagdateregister.proxy;


import ma.computime.microservicetagdateregister.entities.TagDateRegister;
import ma.computime.microservicetagdateregister.entities.mData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.util.List;

@FeignClient(value = "microservice-tag-reader")
public interface MicroserviceTagReaderProxy {

    @PostMapping("/formattedTag")
    List<TagDateRegister> getFormattedTag(@RequestBody List<mData> listemdata) throws ParseException;
}
