package ma.computime.microservicetagreader.proxy;

import ma.computime.microservicetagreader.bean.TagBean;
import ma.computime.microservicetagreader.bean.mDataBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "microservice-tag-reader")
@RibbonClient(value = "microservice-tag-reader")
public interface MicroserviceTagReaderProxy {

    @PostMapping("/formattedTag")
    List<TagBean> getFormattedTag(@RequestBody List<mDataBean> list);

}
