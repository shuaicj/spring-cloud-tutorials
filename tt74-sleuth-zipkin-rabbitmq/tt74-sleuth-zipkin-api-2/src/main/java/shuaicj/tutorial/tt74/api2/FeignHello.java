package shuaicj.tutorial.tt74.api2;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign client.
 *
 * @author shuaicj 2017/12/23
 */
@FeignClient(name = "tt74-api-3", path = "/hello")
public interface FeignHello {

    @GetMapping("/")
    String hello(@RequestParam("name") String name);
}
