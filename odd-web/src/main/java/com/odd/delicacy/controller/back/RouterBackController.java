package com.odd.delicacy.controller.back;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台路由控制器
 *
 * @author Tanglinfeng
 * @date 2021/7/9 14:52
 */
@RequestMapping("/back/admin")
@Controller
public class RouterBackController {

    @GetMapping("/index")
    public String toBackIndex() {
        return "back/index";
    }

    @GetMapping("/login")
    public String toLogin() {
        return "back/login";
    }
}
