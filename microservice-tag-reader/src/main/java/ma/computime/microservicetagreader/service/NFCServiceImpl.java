package ma.computime.microservicetagreader.service;


import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NFCServiceImpl implements NFCService {

    @Override
    public List<String> tagFormat(String s) {
        return formatCSV(s);
    }


    private static List<String> formatCSV(String s) {
        List<String> list;
        String separator = ",";
        list = Arrays.asList(s.split(separator));
        return list;
    }


}
