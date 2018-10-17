package shuaicj.tutorial.cloud.tt01.client;

import java.util.List;
import java.util.Map;

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

    @Value("${hello.message}")
    private String message;

    @Value("${hello.chars}")
    private List<String> chars;

    @Value("#{${hello.dict}}")
    private Map<String, Integer> dict;

    @GetMapping("/hello")
    public String hello() {
        return "port: " + port + ", message: " + message + "\n";
    }

    @GetMapping("/chars")
    public String chars() {
        return chars + "\n";
    }

    @GetMapping("/dict")
    public String dict() {
        return dict + "\n";
    }
}
