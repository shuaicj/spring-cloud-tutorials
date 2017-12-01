package shuaicj.tutorial.cloud.tt22.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * Spring boot app with hystrix.
 *
 * @author shuaicj 2017/12/01
 */
@SpringBootApplication
@EnableCircuitBreaker
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
