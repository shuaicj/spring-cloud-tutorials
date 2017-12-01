package shuaicj.tutorial.cloud.tt21;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/12/01
 */
@RestController
public class HelloController {

    @Autowired
    StringOps stringOps;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "Hello " + stringOps.capitalize(name) + "!";
    }

    @Component
    static class StringOps {

        @HystrixCommand(fallbackMethod = "capitalizeFallback")
        String capitalize(String s) {
            if (s.length() < 3) {
                throw new IllegalArgumentException("too short");
            }
            return s.toUpperCase();
        }

        String capitalizeFallback(String s) {
            return s.toUpperCase() + " [FALLBACK]";
        }
    }
}
