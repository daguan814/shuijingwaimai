package org.shuijing.shuijingwaimai.dao;

import org.apache.ibatis.annotations.Mapper;
import org.shuijing.shuijingwaimai.pojo.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 员工信息 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2022-07-18
 */

@Mapper
public interface EmployeeDao extends BaseMapper<Employee> {

}
