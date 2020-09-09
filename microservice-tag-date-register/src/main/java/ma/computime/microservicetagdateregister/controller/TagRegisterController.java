package ma.computime.microservicetagdateregister.controller;


import ma.computime.microservicetagdateregister.entities.TagDateRegister;
import ma.computime.microservicetagdateregister.entities.mData;
import ma.computime.microservicetagdateregister.proxy.MicroserviceTagProxy;
import ma.computime.microservicetagdateregister.proxy.MicroserviceTagReaderProxy;
import ma.computime.microservicetagdateregister.service.TagDateRegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/tagdateregister")
public class TagRegisterController {

    private final TagDateRegisterService tagDateRegisterService;

    private final MicroserviceTagProxy microserviceTagProxy;

    private final MicroserviceTagReaderProxy microserviceTagReaderProxy;


    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public TagRegisterController(TagDateRegisterService tagDateRegisterService, MicroserviceTagProxy microserviceTagProxy, MicroserviceTagReaderProxy microserviceTagReaderProxy) {
        this.tagDateRegisterService = tagDateRegisterService;
        this.microserviceTagProxy = microserviceTagProxy;
        this.microserviceTagReaderProxy = microserviceTagReaderProxy;
    }

    @GetMapping
    public List<TagDateRegister> getAll(){
        return tagDateRegisterService.getAll();
    }

    @GetMapping("/{id}")
    public TagDateRegister get(@PathVariable int id){
        return tagDateRegisterService.get(id);
    }

    @PostMapping("/employeesbytime")
    public List<TagDateRegister> getAllBetweenAandB(@RequestBody mData dates) throws ParseException {
        List<String> strings = Arrays.asList(dates.getM().split(","));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC+1"));
        return tagDateRegisterService.findAllBetween(dateFormat.parse(strings.get(0)),dateFormat.parse(strings.get(1)));
    }

    @PostMapping("/add")
    public ResponseEntity<List<TagDateRegister>> add(@RequestBody List<mData> list) throws ParseException {
        List<TagDateRegister> listtagDateRegister = microserviceTagReaderProxy.getFormattedTag(list);
        List<TagDateRegister> tagDateRegisters = new ArrayList<>();
        List<TagDateRegister> notfoundTag = new ArrayList<>();
        for(TagDateRegister tagDateRegister:listtagDateRegister) {
            if (microserviceTagProxy.getTag(tagDateRegister.getUid())!= null) {
                if(microserviceTagProxy.getTag(tagDateRegister.getUid()).getBody().getPersonne_id()!=0){
                    tagDateRegisters.add(tagDateRegister);
                }else{
                    notfoundTag.add(tagDateRegister);
                }
            }
        }
        logger.info("Add register");
        if(tagDateRegisters.size()==listtagDateRegister.size()) return ResponseEntity.ok(tagDateRegisterService.addAll(tagDateRegisters));
        return ResponseEntity.unprocessableEntity().body(notfoundTag);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        tagDateRegisterService.delete(id);
    }

}
