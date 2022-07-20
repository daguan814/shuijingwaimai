package org.shuijing.shuijingwaimai.service.impl;

import org.shuijing.shuijingwaimai.pojo.Category;
import org.shuijing.shuijingwaimai.dao.CategoryDao;
import org.shuijing.shuijingwaimai.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜品及套餐分类 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-07-20
 */
@Service
public class CategoryServiceImp extends ServiceImpl<CategoryDao, Category> implements CategoryService {

}
