package com.km.service.impl;

import com.km.mapper.ProductMapper;
import com.km.pojo.Product;
import com.km.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> queryAllProducts() {
        List<Product> products = this.productMapper.selectList(null);//无条件查询
        return products;
    }
}
