package shuaicj.tutorial.tt51.api1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/12/05
 */
@RestController
public class ConsumerController {

    @Autowired
    FeignHello1 feignHello;

    @GetMapping("/consume")
    public String consume() {
        return feignHello.hello("API1-CONSUMER");
    }
}
