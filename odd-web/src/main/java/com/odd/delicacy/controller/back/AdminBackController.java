package com.odd.delicacy.controller.back;

import com.odd.delicacy.api.ResponseBean;
import com.odd.delicacy.entity.admin.Administer;
import com.odd.delicacy.service.admin.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@AllArgsConstructor
@RequestMapping("/back/admin")
@RestController
public class AdminBackController {

    private final AdminService adminService;

    @PostMapping("auth")
    public ResponseBean<Boolean> login(Administer administer, HttpSession session) {
        boolean success = adminService.login(administer.getUsername(), administer.getPassword());
        if (success) {
            session.setAttribute("adminName", administer.getUsername());
            return ResponseBean.success(true);
        } else {
            return ResponseBean.fail(403, "用户名或密码错误");
        }
    }
}
