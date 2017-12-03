package shuaicj.tutorial.cloud.tt23.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Hystrix Dashboard.
 *
 * @author shuaicj 2017/12/01
 */
@SpringBootApplication
@EnableHystrixDashboard
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }
}
