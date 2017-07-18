package shuaicj.tutorial.cloud.tt03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/07/18
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private int port;

    @Value("${hello.message}")
    private String message;

    @GetMapping("/hello")
    public String hello() {
        return "port: " + port + ", message: " + message + "\n";
    }
}
