package com.km.controller;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.core.lang.Console;
import com.km.pojo.User;
import com.km.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class LoginController {

    // 注入service
    //注入，将具体的实现类默认按照其类型注入，接口的子类也是属于该类型，所以
    @Autowired
    private UserService userService;
//默认get
    @GetMapping(value = "/login")
    public String loginpage() {
  //直接返回以login名称的html，因为配置了themeleaf模板引擎
        return "login";//没蓝springmvc配置视图解析器，但boot都帮你写好了，都写了的，只不过在源码里
    }


    // login 登录逻辑

    @PostMapping(value = "/doLogin")//看清楚是postmapping
    public String login(String userName, String userPassword, String valideCode,
                        HttpSession session,
                        Model model) {
        // 校验验证码是否正确
        // 先取出 系统的验证码  从session 中取出
        String randomCode = (String) session.getAttribute("checkCode");
        // 拿到我们当前用户输入的验证码
        String code = valideCode;
        // 比较验证码
        if (!randomCode.equalsIgnoreCase(code)) {
            // 验证码错误
            model.addAttribute("errorMsg", "验证码错误");
            //string 只是返回页面，没得数据，所以要通过model
            //返回页面之前，先存数据，因为返回值是string，所以借助model,所以在方法参数里声明了一个Model
            //返回值是model and view就自带数据装载
            //返回值是void and 好像就需要原生的reques域存数据样

            // 回到登录界面
            return "login";//如果验证码出错，将不会继续向下执行，会返回到login页面,一定是，因为返回值是String，就结束啦
        }

        // 校验用户名和密码
        // select * from tb_user where userName="KK" and password="11"
        List<User> list = this.userService.checkLogin(userName, userPassword);
        if (list.size() > 0 && list != null) {  //没找到就返回null，这个就是false
            // 成功进入到主页
            //return "index";
            // 请求   重定向  QueryAllProducts  这里才有数据
            return "redirect:/QueryAllProducts";//重定向好一些
        } else {
            // 用户名或者错误的时候
            model.addAttribute("errorMsg", "用户名或者密码错误");
            return "login";
        }
    }




/*    @GetMapping(value = "/aa")
    public void  aa(HttpServletResponse response, HttpServletRequest request) throws IOException {
        //定义图形验证码的长和宽
       // LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(150, 150);
        CircleCaptcha captcha = CaptchaUtil.createCircleCaptcha(200, 100, 4, 0);

        //图形验证码写出，可以写出到文件，也可以写出到流
       // lineCaptcha.write("d:/line.png");
        //输出code
        Console.log(captcha.getCode());
        captcha.write(response.getOutputStream());
//Servlet的OutputStream记得自行关闭哦！
    }*/
}
