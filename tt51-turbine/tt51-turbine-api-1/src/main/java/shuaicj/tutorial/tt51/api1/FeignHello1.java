package shuaicj.tutorial.tt51.api1;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client.
 *
 * @author shuaicj 2017/12/05
 */
@FeignClient(name = "tt51-api-2", path = "/hello", fallback = FeignHello1.FeignHelloImpl.class)
public interface FeignHello1 {

    @GetMapping("/")
    String hello(@RequestParam("name") String name);

    @Component
    class FeignHelloImpl implements FeignHello1 {

        public String hello(String name) {
            return name + " [API1-FALLBACK]\n";
        }
    }
}
