package io.dino.learning.apigateway;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@Profile("some_profile") // to enable only for some profile but never for prod
public class HttpTraceActuatorConfiguration {

    /**
     * Starting Spring Boot 2.2.x, you have to instantiate a bean of type
     * InMemoryHttpTraceRepository to enable the /actuator/trace.
     * Prior 2.2.x, all you had to do is add spring-boot-starter-actuator
     * dependency and in application.properties expose actuator endpoints by
     * use of management.endpoints.web.exposure.include=....
     * Post 2.2.x, you also have to add a bean method, best in its own config
     * class like here.
     * EXPLANATION: This is not a bug but intentional change as httptrace
     * captures data in memory and consumes lots of it without user knowing or
     * needing it.  In cluster environments, memory is precious and Spring Boot
     * was invented to simplify cluster deployments.  For that reason, httptrace
     * actuator was turned off by default requiring user to turn it on explicityly.
     */
    @Bean
    public HttpTraceRepository htttpTraceRepository()
    {
        return new InMemoryHttpTraceRepository();
    }
}
