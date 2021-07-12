package com.odd.delicacy.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class RouterFrontController {

    @GetMapping({"", "index"})
    public String index() {
        return "front/index";
    }

    @GetMapping("about")
    public String about() {
        return "front/about";
    }

    @GetMapping("product")
    public String product() {
        return "front/product";
    }

    @GetMapping("join")
    public String join() {
        return "front/join/join";
    }

    @GetMapping("store")
    public String store() {
        return "front/store";
    }

    @GetMapping("news")
    public String news() {
        return "front/news";
    }

    @GetMapping("contact")
    public String contact() {
        return "front/contact";
    }

    @GetMapping("join/advantage")
    public String toJoinAdvantage(){return "front/join/joinAdvantage";}

    @GetMapping("join/flow")
    public String toJoinFlow(){return "front/join/joinFlow";}

    @GetMapping("join/apply")
    public String toJoinApply(){return "front/join/joinApply";}
}
