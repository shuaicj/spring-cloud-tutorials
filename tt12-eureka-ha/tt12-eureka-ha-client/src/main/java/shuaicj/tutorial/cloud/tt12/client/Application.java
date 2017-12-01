package shuaicj.tutorial.cloud.tt12.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Eureka client.
 *
 * @author shuaicj 2017/12/01
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
