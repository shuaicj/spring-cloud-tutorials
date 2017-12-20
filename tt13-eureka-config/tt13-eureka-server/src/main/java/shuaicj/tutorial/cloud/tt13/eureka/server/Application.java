package shuaicj.tutorial.cloud.tt13.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka server.
 *
 * @author shuaicj 2017/12/20
 */
@SpringBootApplication
@EnableEurekaServer
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
