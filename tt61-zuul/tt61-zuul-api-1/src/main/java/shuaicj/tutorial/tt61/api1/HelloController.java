package shuaicj.tutorial.tt61.api1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/12/22
 */
@RestController
public class HelloController {

    @Value("${hello.id}")
    private String id;

    @GetMapping("/hello")
    public String hello() {
        return "API1-" + id + " says hello!\n";
    }
}
