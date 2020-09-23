package com.km.controller;


import com.km.mapper.ProductMapper;
import com.km.pojo.Product;
import com.km.service.ProductService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class ProductController {

//依赖注入
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;//将接口变成实现类，这行非常重要,

    // 查询数据 返回list
    @GetMapping(value = "/QueryAllProducts")//是通过之前的重定向，才有数据，因为如果只return index，只有页面，没得数据
    public ModelAndView QueryAllProducts() {

        ModelAndView modelAndView = new ModelAndView();
        // 调用service 层

        List<Product> productList = this.productService.queryAllProducts();

        // 先将数据库查询的数据存起来
        modelAndView.addObject("productList", productList);

        // 设置跳转的视图
        modelAndView.setViewName("index");
        return modelAndView;
    }

    // 删除功能实现,这个不需要


    // 下架功能实现，实际上是逻辑删除
    @GetMapping(value = "/closedProductById")//因为别人访问它，是要在网址上有值的，所以用getmapping
    public String closedProductById(String pid) {


        System.out.println("pid========" + pid + "已下架");//没有真正调用，只是表示一下

        this.productMapper.deleteById(Integer.parseInt(pid));//boot用的plus少了点什么，简化了

        // 调用service  调用dao 层  去删除 即可
        //下面类似前端的重载，再次刷新页面,/QueryAllProducts就会再次请求刷新页面
        return "redirect:/QueryAllProducts";//转发与重定向的区别认识又加深了，
        //1.返回一个有数据的页面，而不是只是页面 2.到底变不变网址，重定向要变成redirect后面的访问的，forward不会变
        // 重定向就像android里面的notifyAdaterchange，通知数据改变，实时更新
        //非常非常重要，这一点
    }

}
