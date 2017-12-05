package shuaicj.tutorial.tt51.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Spring boot app.
 *
 * @author shuaicj 2017/12/05
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbine
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
