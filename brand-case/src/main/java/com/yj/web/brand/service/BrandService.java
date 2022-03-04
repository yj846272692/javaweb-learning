package com.yj.web.brand.service;

import com.yj.web.brand.pojo.Brand;
import com.yj.web.brand.pojo.PageBean;

import java.util.List;

/**
 * @program: java-web-learning
 * @description:
 * @author: YG.
 * @create: 2022-03-04
 **/
public interface BrandService {
    /**
     * 查询所有
     *
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加数据
     *
     * @param brand
     */
    void add(Brand brand);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);

    /**
     * 分页条件查询
     *
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage, int pageSize, Brand brand);
}