package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author limei
 * @date 2024/3/22 16:21
 * @description 菜品口味
 */

@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入口味数据
     * */
    void insertBatch(List<DishFlavor> flavors);

    /**
     * 根据菜品id删除菜品
    * */
    @Delete("delete from dish_flavor where dish_id = #{dishId}")
    void deleteByDishId(Long dishId);

    /**
     * 根据菜品id删除菜品口味数据
     * */
    void deleteByDishIds(List<Long> dishIds);

    @Select("select * from dish_flavor where dish_id = #{dishId}")
    List<DishFlavor> getByDishId(Long dishId);
}
