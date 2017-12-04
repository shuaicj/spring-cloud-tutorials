package shuaicj.tutorial.tt41.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Spring boot app.
 *
 * @author shuaicj 2017/12/03
 */
@SpringBootApplication
@EnableFeignClients
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
