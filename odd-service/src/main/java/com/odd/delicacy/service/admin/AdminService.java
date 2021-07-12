package com.odd.delicacy.service.admin;

import com.odd.delicacy.base.BaseService;
import com.odd.delicacy.entity.admin.Administer;
import com.odd.delicacy.mapper.admin.AdminMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;


@Service
public class AdminService extends BaseService<AdminMapper, Administer> {

    public boolean login(String username, String password) {
        Administer administer = mapper.findByUsername(username);
        if (administer == null) return false;
        String passed = DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8));
        String db = administer.getPassword();
        return db.equals(passed);
    }

    public boolean logout() {
        return false;
    }
}
