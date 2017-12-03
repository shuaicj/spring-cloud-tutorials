package shuaicj.tutorial.tt22.consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/12/03
 */
@RestController
public class ConsumerController {

    @Autowired
    Consumer consumer;

    @GetMapping("/consume")
    public String consume() {
        return consumer.hello("CONSUMER");
    }

    @Component
    static class Consumer {

        @HystrixCommand(fallbackMethod = "helloFallback")
        String hello(String name) {
            return new RestTemplate().getForObject("http://localhost:8080/hello?name={name}", String.class, name);
        }

        @SuppressWarnings("unused")
        String helloFallback(String name) {
            return name + " [FALLBACK]\n";
        }
    }
}
