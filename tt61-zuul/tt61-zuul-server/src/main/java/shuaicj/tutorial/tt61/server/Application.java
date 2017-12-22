package shuaicj.tutorial.tt61.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Zuul gateway.
 *
 * @author shuaicj 2017/12/22
 */
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
