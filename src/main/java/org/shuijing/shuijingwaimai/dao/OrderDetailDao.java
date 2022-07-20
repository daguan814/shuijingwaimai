package org.shuijing.shuijingwaimai.dao;

import org.shuijing.shuijingwaimai.pojo.OrderDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单明细表 Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2022-07-20
 */
@Mapper
public interface OrderDetailDao extends BaseMapper<OrderDetail> {

}
