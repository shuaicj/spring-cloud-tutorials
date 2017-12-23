package shuaicj.tutorial.tt52.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

/**
 * Spring boot app.
 *
 * @author shuaicj 2017/12/23
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableTurbineStream
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
