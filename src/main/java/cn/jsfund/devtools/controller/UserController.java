//package cn.jsfund.devtools.controller;
//
//import cn.jsfund.devtools.base.controller.BaseWebController;
//import cn.jsfund.devtools.common.bean.Result;
//import cn.jsfund.devtools.entity.User;
//import cn.jsfund.devtools.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
///**
// * Created by hutx on 17:19 2018/11/23
// */
//@RestController
//@RequestMapping("/api/users")
//public class UserController extends BaseWebController<User> {
//
//
//
//    @PostMapping("login")
//    public Result login(@RequestBody Map<String, String> map) throws Exception {
//        return this.successReturn().setData("status", "ok").setData("currentAuthority", "admin");
//    }
//
//    @GetMapping("currentUser")
//    public Result currentUser() throws Exception {
//        User user = new User();
//        user.setId(1);
//        return this.successReturn(service.listOne(user));
//    }
//
//}
