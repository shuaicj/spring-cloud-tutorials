package shuaicj.tutorial.tt42.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client.
 *
 * @author shuaicj 2017/12/03
 */
@FeignClient(name = "tt42-api", path = "/hello", fallback = FeignHello.FeignHelloImpl.class)
public interface FeignHello {

    @GetMapping("/")
    String hello(@RequestParam("name") String name);

    @Component
    class FeignHelloImpl implements FeignHello {

        public String hello(String name) {
            return name + " [FALLBACK]\n";
        }
    }
}
