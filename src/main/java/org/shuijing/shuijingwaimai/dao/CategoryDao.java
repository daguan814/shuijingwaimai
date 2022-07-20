package org.shuijing.shuijingwaimai.dao;

import org.shuijing.shuijingwaimai.pojo.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜品及套餐分类 Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2022-07-20
 */
@Mapper
public interface CategoryDao extends BaseMapper<Category> {

}
