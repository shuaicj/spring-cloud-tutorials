package shuaicj.tutorial.tt73.zipkin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * Spring boot app.
 *
 * @author shuaicj 2017/12/23
 */
@SpringBootApplication
@EnableZipkinServer
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
