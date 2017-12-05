package shuaicj.tutorial.tt51.api2;

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
    FeignHello2 feignHello;

    @GetMapping("/consume")
    public String consume() {
        return feignHello.hello("API2-CONSUMER");
    }
}
