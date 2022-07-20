package org.shuijing.shuijingwaimai.dao;

import org.shuijing.shuijingwaimai.pojo.Dish;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜品管理 Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2022-07-20
 */
@Mapper
public interface DishDao extends BaseMapper<Dish> {

}
