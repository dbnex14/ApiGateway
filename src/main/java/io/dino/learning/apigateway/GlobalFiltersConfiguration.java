package io.dino.learning.apigateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration
public class GlobalFiltersConfiguration {

    final Logger logger = LoggerFactory.getLogger(MyPreFilter.class);

    @Order(1)
    @Bean
    public GlobalFilter secondPreFilter() {
        return ((exchange, chain) -> {
            logger.info("My 2nd global Pre-Filter was executed ...");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("My 2nd global Post-Filter was executed ...");
            }));
        });
    }

    @Order(2)
    @Bean
    public GlobalFilter thirtPreFilter() {
        return ((exchange, chain) -> {
            logger.info("My 3rd global Pre-Filter was executed ...");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("My 3rd global Post-Filter was executed ...");
            }));
        });
    }

    @Order(3)
    @Bean
    public GlobalFilter fourthPreFilter() {
        return ((exchange, chain) -> {
            logger.info("My 4th global Pre-Filter was executed ...");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("My 4th global Post-Filter was executed ...");
            }));
        });
    }
}
