package ma.computime.microservicetagdateregister.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if(response.status()==404){
            return new TagNotFoundException("Tag not found");
        }
        return errorDecoder.decode(methodKey,response);
    }
}
