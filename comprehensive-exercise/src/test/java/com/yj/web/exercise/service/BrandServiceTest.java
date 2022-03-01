package com.yj.web.exercise.service;

import com.yj.web.exercise.entity.Brand;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class BrandServiceTest {
    private BrandService brandService;

    @Test
    void selectAll() {
        brandService = new BrandService();
        List<Brand> brands = brandService.selectAll();
        log.info(String.valueOf(brands));
    }

    @Test
    void add() {
        brandService = new BrandService();
        Brand brand = Brand.builder()
                .brandName("测试商品")
                .companyName("测试公司")
                .ordered(0)
                .description("这是一个测试数据")
                .status(1).build();
        brandService.add(brand);
        log.info(String.valueOf(brand));
    }

    @Test
    void selectById() {
        brandService = new BrandService();
        Brand  brand =brandService.selectById(1);
        log.info(String.valueOf(brand));
    }

    @Test
    void update() {
        brandService = new BrandService();
        Brand brand = brandService.selectById(17);
        brand.setBrandName("测试测试测试");
        brandService.update(brand);
        log.info(String.valueOf(brand));
    }

    @Test
    void delete() {
        brandService = new BrandService();
        Brand brand = new Brand();
        brand.setId(18);
        brandService.delete(brand);
        log.info("删除成功");
    }
}