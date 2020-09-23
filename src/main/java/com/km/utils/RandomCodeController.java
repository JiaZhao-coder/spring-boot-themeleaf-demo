package com.km.utils;


import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ICaptcha;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class RandomCodeController {
    @GetMapping(value = "/getCheckCode")//方法里声明response，session整个浏览器通用的信息，所以靠他,是有用的
    public void getCheckCode(HttpServletResponse response, HttpSession session) throws IOException {
        //因为这是产生验证码的功能，不返回视图，所以void
        // 定义验证码的长和宽
        //ICaptcha captcha =  CaptchaUtil.createLineCaptcha(115, 30);
        //codeCount,指明有四个字母，line指明干扰线一共有0条可以修改
        //CaptchaUtil.createLineCaptcha创造一个LineCaptcha，ICaptcha，看到这个开头大写的I，应该是接口，多态的体现
        //LineCaptcha现在类似于是一个带有四个字母或数字的图片
        ICaptcha captcha = CaptchaUtil.createLineCaptcha(113, 30, 4, 0);
        //将生成的验证码存在session域中
        session.setAttribute("checkCode", captcha.getCode());
        // 将生成的验证码写入到页面显示
        //写到那儿去
        captcha.write(response.getOutputStream());//回应给，那个请求它的页面,且跟平常的
        //平常都是流对象调用相应的方法,与上面这个有点不一样
    }


}
