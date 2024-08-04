package syk.study.security.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactRestController {
    @GetMapping("/login")
    public String test() {
        return "hello test";
    }
}