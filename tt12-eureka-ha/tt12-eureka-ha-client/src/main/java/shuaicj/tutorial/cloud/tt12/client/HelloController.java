package shuaicj.tutorial.cloud.tt12.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 *
 * 'GET /hello' will return all instance info fetched from eureka server.
 *
 * @author shuaicj 2017/12/01
 */
@RestController
public class HelloController {

    @Value("${spring.application.name}")
    private String name;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public Map<String, List<ServiceInstance>> hello() {
        Map<String, List<ServiceInstance>> map = new HashMap<>();
        for (String service : discoveryClient.getServices()) {
            map.put(service, discoveryClient.getInstances(service));
        }
        return map;
    }
}
