package HenriqueSPiana.com.github.Estudo_springboot.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

        /**
         *
         * VIA QUERY PARAM http://localhost:8080/api/person/v1/2?mediaType=xml
         *
         *
        WebMvcConfigurer.super.configureContentNegotiation(configurer);
        configurer.favorParameter(true)
                .parameterName("mediaType")
                .ignoreAcceptHeader(true)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json",MediaType.APPLICATION_JSON)
                .mediaType("XML",MediaType.APPLICATION_XML);
       */
        //VIA HEADER PARAM http://localhost:8080/api/person/v1/2?mediaType=xml
        //PARA USAR VIA HEADER NECESSARIO UTILIZAR O PARAMETRO Accept DE VALOR = application/xml
        WebMvcConfigurer.super.configureContentNegotiation(configurer);
        configurer.favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json",MediaType.APPLICATION_JSON)
                .mediaType("XML",MediaType.APPLICATION_XML);


    }
}
