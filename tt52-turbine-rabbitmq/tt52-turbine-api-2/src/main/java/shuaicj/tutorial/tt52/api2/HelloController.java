package shuaicj.tutorial.tt52.api2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/12/23
 */
@RestController
public class HelloController {

    @Value("${hello.id}")
    private String id;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) throws InterruptedException {
        if (Math.random() > 0.5) {
            TimeUnit.MILLISECONDS.sleep(2000); //randomly sleep for triggering hystrix fallback
        }
        return "API2-" + id + " says hello to " + name + "!\n";
    }
}
