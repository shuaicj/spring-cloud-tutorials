package shuaicj.tutorial.cloud.tt02.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller.
 *
 * @author shuaicj 2017/07/17
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private int port;

    @Value("${tt02.hello.author}")
    private String author;

    @GetMapping("/hello")
    public String hello() {
        return "port: " + port + ", author: " + author + "\n";
    }
}
