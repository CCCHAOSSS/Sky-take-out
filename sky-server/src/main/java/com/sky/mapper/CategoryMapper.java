package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author limei
 * @date 2024/3/21 13:17
 * @description 菜品管理mapper
 */
@Mapper
public interface CategoryMapper {

    @Insert("insert into category (type, name, sort, status, create_time, update_time, create_user, update_user) " +
            "VALUES "
            +"(#{type}, #{name}, #{sort}, #{status}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    @AutoFill(value = OperationType.INSERT)
    void insert(Category category);

    /**
     * 分页查询
     * */
    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * 根据id删除种类
     * */
    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);

    /**
     * 更新菜品
     * */
    @AutoFill(value = OperationType.UPDATE)
    void update(Category category);

    /**
     * 根据类型查询分类
     * */
    List<Category> list(Integer type);
}