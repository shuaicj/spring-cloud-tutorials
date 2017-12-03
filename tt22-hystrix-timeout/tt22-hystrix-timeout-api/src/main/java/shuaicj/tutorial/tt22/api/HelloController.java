package shuaicj.tutorial.tt22.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/12/03
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name) throws InterruptedException {
        if (Math.random() > 0.5) {
            TimeUnit.MILLISECONDS.sleep(2000); //randomly sleep for triggering hystrix fallback
        }
        return "Hello " + name + "!\n";
    }
}
