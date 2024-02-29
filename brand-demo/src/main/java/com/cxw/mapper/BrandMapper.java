package com.cxw.mapper;

import com.cxw.pojo.Brand;

import java.util.List;

public interface BrandMapper {

    List<Brand> selectAll ();

//    就一个参数所以不用写@Param注解
    void add(Brand brand);

    Brand selectById(String id);

    void update(Brand brand);

    void deleteById(String id);
}
