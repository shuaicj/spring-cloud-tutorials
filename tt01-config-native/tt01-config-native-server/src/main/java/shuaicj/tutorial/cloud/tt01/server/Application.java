package shuaicj.tutorial.cloud.tt01.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Config server.
 *
 * @author shuaicj 2017/07/17
 */
@SpringBootApplication
@EnableConfigServer
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
