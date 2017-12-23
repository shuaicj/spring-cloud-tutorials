package shuaicj.tutorial.tt73.api2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/12/23
 */
@RestController
public class HelloController {

    @Autowired
    FeignHello feignHello;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "[" + name + " call API2]\n" + feignHello.hello("API2");
    }
}
