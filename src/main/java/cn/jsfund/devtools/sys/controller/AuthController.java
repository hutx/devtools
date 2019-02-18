package cn.jsfund.devtools.sys.controller;

import cn.jsfund.devtools.common.bean.Result;
import cn.jsfund.devtools.sys.entity.SysUser;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public Result auth(SysUser user) {
        Result result = new Result();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
        try {
            subject.login(token);
            result.setData("token", subject.getSession().getId());
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
        Result result = new Result(200, new JSONObject(), "未登录", "未登录");
        return result;
    }
}
