package com.binto.sell.controller;

import com.binto.sell.VO.ProductInfoVO;
import com.binto.sell.VO.ProductVO;
import com.binto.sell.VO.ResultVO;
import com.binto.sell.dataobject.ProductInfo;
import com.binto.sell.service.CategoryService;
import com.binto.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list()
    {
        //1. 查询所有上架商品
        List<ProductInfo> productInfoList = productService.findUpAll();

        //2. 查询类目(一次性查询）
        

        //3. 数据拼装
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");

        ProductVO productVO = new ProductVO();
        ProductInfoVO productInfoVO = new ProductInfoVO();
        productVO.setProductInfoVOList(Arrays.asList(productInfoVO));
        resultVO.setData(productVO);

        return resultVO;
    }
}
