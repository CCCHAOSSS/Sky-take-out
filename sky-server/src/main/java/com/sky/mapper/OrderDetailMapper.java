package com.sky.mapper;

import com.sky.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author limei
 * @date 2024/3/28 16:46
 * @description
 */

@Mapper
public interface OrderDetailMapper {

    /**
     * 批量插入订单明细数据
     * */
    void insertBatch(List<OrderDetail> orderDetailList);

    /**
     *
     * */
    @Select("select  * from order_detail where order_id = #{orderId}")
    List<OrderDetail> getByOrderId(Long orderId);
}