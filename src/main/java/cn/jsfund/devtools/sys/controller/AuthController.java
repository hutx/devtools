package cn.jsfund.devtools.sys.controller;

import cn.jsfund.devtools.common.bean.Result;
import cn.jsfund.devtools.util.JWTUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public Result auth(@RequestParam("username") String username,
                       @RequestParam("password") String password) {
        Result result = new Result();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            result.setData("token", JWTUtil.createToken(username));
            result.setMsg("登录成功！");

        } catch (IncorrectCredentialsException e) {
            result.setMsg("密码错误！");
        } catch (LockedAccountException e) {
            result.setMsg("登录失败，该用户已被冻结！");
        } catch (AuthenticationException e) {
            result.setMsg("登录失败，该用户不存在！");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("/unauth")
    public Result unAuth() {
        Result result = new Result(200, null, null, "未登录", "未登录");
        return result;
    }
}
