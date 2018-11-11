package com.binto.sell.repository;

import com.binto.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest()
    {
        ProductCategory productCategory = repository.findById(1).get();
        System.out.println(productCategory.toString());
    }

    @Test
    public void saveTest()
    {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(10);

        repository.save(productCategory);
    }

    @Test
    @Transactional
    public void updateTest()
    {
        ProductCategory productCategory = repository.findById(1).get();
        productCategory.setCategoryType(1);
        System.out.println(productCategory.toString());

        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest()
    {
        List<Integer> list = Arrays.asList(1,3,4);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }
}