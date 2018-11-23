package cn.jsfund.devtools.controller;

import cn.jsfund.devtools.base.controller.BaseController;
import cn.jsfund.devtools.bean.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by hutx on 17:19 2018/11/23
 */
@RestController
@RequestMapping("/api/users")
public class LoginController extends BaseController {

    @PostMapping("login")
    public Result login(@RequestBody Map<String, String> map) throws Exception {
        return this.successReturn().setData("status", "ok");
    }
}
