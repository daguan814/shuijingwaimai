package org.shuijing.shuijingwaimai.service.impl;

import org.shuijing.shuijingwaimai.pojo.Employee;
import org.shuijing.shuijingwaimai.dao.EmployeeDao;
import org.shuijing.shuijingwaimai.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工信息 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2022-07-18
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, Employee> implements IEmployeeService {

}
