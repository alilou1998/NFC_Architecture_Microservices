package ma.computime.microservicetag.proxy;

import ma.computime.microservicetag.bean.NewTagBean;
import ma.computime.microservicetag.bean.mDataBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "microservice-tag-reader")
@RibbonClient(value = "microservice-tag-reader")
public interface MicroserviceTagReaderProxy {


    @PostMapping("/formatTag")
    List<NewTagBean> formatNewTag(@RequestBody List<mDataBean> list);

}
