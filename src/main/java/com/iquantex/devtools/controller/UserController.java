package com.iquantex.devtools.controller;

import com.iquantex.devtools.base.controller.BaseWebController;
import com.iquantex.devtools.bean.Result;
import com.iquantex.devtools.model.User;
import com.iquantex.devtools.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by hutx on 17:19 2018/11/23
 */
@RestController
@RequestMapping("/api/users")
public class UserController extends BaseWebController<User> {

    @Autowired
    private UserService service;

    @PostMapping("login")
    public Result login(@RequestBody Map<String, String> map) throws Exception {
        return this.successReturn().setData("status", "ok").setData("currentAuthority", "admin");
    }

    @GetMapping("currentUser")
    public Result currentUser() throws Exception {
        User user = new User();
        user.setId(1);
        return this.successReturn(service.listOne(user));
    }

    @Override
    public UserService getService() {
        return service;
    }
}
