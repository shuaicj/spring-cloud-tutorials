package shuaicj.tutorial.tt31.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/12/02
 */
@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consume")
    public String consume() {
        return restTemplate.getForObject("http://hello-service/hello", String.class);
    }
}
