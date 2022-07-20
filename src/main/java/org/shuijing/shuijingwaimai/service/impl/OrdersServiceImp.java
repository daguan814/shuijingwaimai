package org.shuijing.shuijingwaimai.service.impl;

import org.shuijing.shuijingwaimai.pojo.Orders;
import org.shuijing.shuijingwaimai.dao.OrdersDao;
import org.shuijing.shuijingwaimai.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-07-20
 */
@Service
public class OrdersServiceImp extends ServiceImpl<OrdersDao, Orders> implements OrdersService {

}
