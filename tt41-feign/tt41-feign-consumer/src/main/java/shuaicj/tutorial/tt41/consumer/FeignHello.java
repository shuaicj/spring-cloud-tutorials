package shuaicj.tutorial.tt41.consumer;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client.
 *
 * @author shuaicj 2017/12/03
 */
@FeignClient(name = "tt41-api", path = "/hello")
public interface FeignHello {

    @GetMapping("/")
    String hello(@RequestParam("name") String name);
}
