package shuaicj.tutorial.tt71.api1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/12/23
 */
@RestController
public class HelloController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "[" + name + " call API1]\n"
                + restTemplate.getForObject("http://tt71-api-2/hello?name={1}", String.class, "API1");
    }
}
