package shuaicj.tutorial.tt32.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/12/03
 */
@RestController
public class HelloController {

    @Value("${hello.message}")
    private String message;

    @GetMapping("/hello")
    public String hello() {
        return "message: " + message + "\n";
    }
}
