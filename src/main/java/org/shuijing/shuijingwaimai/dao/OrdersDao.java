package org.shuijing.shuijingwaimai.dao;

import org.shuijing.shuijingwaimai.pojo.Orders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2022-07-20
 */
@Mapper
public interface OrdersDao extends BaseMapper<Orders> {

}
