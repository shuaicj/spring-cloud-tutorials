package shuaicj.tutorial.tt42.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/12/03
 */
@RestController
public class ConsumerController {

    @Autowired
    FeignHello feignHello;

    @GetMapping("/consume")
    public String consume() {
        return feignHello.hello("CONSUMER");
    }
}
