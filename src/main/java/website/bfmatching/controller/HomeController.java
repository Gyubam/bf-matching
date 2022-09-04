package website.bfmatching.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home() {

        return "/index";
    }

    @GetMapping("/dd")
    public String info() {

        return "/layout/info";
    }
}
