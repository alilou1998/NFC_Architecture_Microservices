//package ma.computime.microservicetagreader.feignconfig;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//
//@Component
//public class FeignInterceptor implements RequestInterceptor {
//
//    private static final String AUTHORIZATION_HEADER = "Authorization";
//    private static final String TOKEN_TYPE = "Bearer";
//
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Logger logger = LoggerFactory.getLogger(this.getClass());
//        logger.info("OAUTH2 "+SecurityContextHolder.getContext());
//        if ( authentication!=null && authentication.getDetails() instanceof AnonymousAuthenticationToken) {
//
//            AnonymousAuthenticationToken jwt = (AnonymousAuthenticationToken) authentication.getDetails();
//            requestTemplate.header(AUTHORIZATION_HEADER, String.format("%s %s", TOKEN_TYPE, jwt));
//        }
//    }
//
//}
