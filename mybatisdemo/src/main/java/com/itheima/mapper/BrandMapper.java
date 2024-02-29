package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();

    Brand selectById(int id);

//    方式1：@Param 注解
//    List<Brand> selectByCondition(@Param("status")int status,@Param("companyName")String companyName,@Param("brandName")String brandName);

////    方式二、对象
//    List<Brand> selectByCondition(Brand brand);
//
////    方式三、Map
    List<Brand> selectByCondition(Map map);

    Brand selectByConditonSingle(Brand brand);

    void add(Brand brand);

    int update(Brand brand);

    int deleteById(int id);

//    使用@Param注解，指定数组名ids 在mapper 映射文件中也为 ids
    int deleteByIds(@Param("ids") int[] ids);
}
