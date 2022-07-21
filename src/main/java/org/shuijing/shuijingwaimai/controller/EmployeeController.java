package org.shuijing.shuijingwaimai.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.shuijing.shuijingwaimai.common.Result;
import org.shuijing.shuijingwaimai.pojo.Employee;
import org.shuijing.shuijingwaimai.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;

/**
 * <p>
 * 员工信息 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2022-07-20
 */

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/login")
    public Result<Employee> login(HttpServletRequest request , @RequestBody Employee employee){
        //页面提交的代码进行md5加密
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //根据页面提交的用户名查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);  //

        //如果没有查到返回登录失败
        if (emp == null) {
            return Result.error("没有该用户，登录失败！");
        }

        //密码比对，不一致则返回登录失败
        if (!emp.getPassword().equals(password)) {
            return Result.error("密码错误，登录失败！");
        }

        //查看员工状态
        if (emp.getStatus() == 0) {
            return Result.error("账号已禁用");
        }

        //登录成功，将员工id存入session并返回登陆成功结果
        request.getSession().setAttribute("employee",emp.getId());

        return Result.success(emp);

    }

    /**
     * 员工退出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request){
        //清理Session中的员工id、
        request.getSession().removeAttribute("employee");
        return Result.success("退出成功");
    }


}





