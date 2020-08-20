package ma.computime.microservicetag.proxy;

import ma.computime.microservicetag.bean.TagBean;
import ma.computime.microservicetag.bean.mDataBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "microservice-tag-reader",url = "localhost:8181")
public interface MicroserviceTagReaderProxy {

    @PostMapping("/formattedTag")
    TagBean getFormattedTag(@RequestBody mDataBean mdata);

}
