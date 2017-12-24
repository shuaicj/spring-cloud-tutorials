package shuaicj.tutorial.tt74.zipkin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

/**
 * Spring boot app.
 *
 * @author shuaicj 2017/12/23
 */
@SpringBootApplication
@EnableZipkinStreamServer
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
