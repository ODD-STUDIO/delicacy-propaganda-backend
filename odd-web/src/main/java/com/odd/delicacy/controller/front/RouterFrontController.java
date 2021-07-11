package com.odd.delicacy.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RouterFrontController {

    @GetMapping({"/","index"})
    public String index() {
        return "front/index";
    }

    @GetMapping("/about")
    public String about() {
        return "front/about";
    }

    @GetMapping("/product")
    public String product() {
        return "front/product";
    }

    @GetMapping("/join")
    public String join() {
        return "front/join";
    }

    @GetMapping("/jstore")
    public String jStore() {
        return "front/jstore";
    }

    @GetMapping("/news")
    public String news() {
        return "front/news";
    }

    @GetMapping("/contact")
    public String contact() {
        return "front/contact";
    }
}
