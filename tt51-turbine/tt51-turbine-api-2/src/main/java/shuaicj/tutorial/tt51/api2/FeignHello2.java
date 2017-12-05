package shuaicj.tutorial.tt51.api2;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client.
 *
 * @author shuaicj 2017/12/05
 */
@FeignClient(name = "tt51-api-1", path = "/hello", fallback = FeignHello2.FeignHelloImpl.class)
public interface FeignHello2 {

    @GetMapping("/")
    String hello(@RequestParam("name") String name);

    @Component
    class FeignHelloImpl implements FeignHello2 {

        public String hello(String name) {
            return name + " [API2-FALLBACK]\n";
        }
    }
}
