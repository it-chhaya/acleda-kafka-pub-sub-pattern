package kh.edu.cstad.kafkaconsumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String viewIndex() {
        return "index";
    }

}
