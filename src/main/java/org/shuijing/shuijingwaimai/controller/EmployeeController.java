package org.shuijing.shuijingwaimai.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.shuijing.shuijingwaimai.common.Result;
import org.shuijing.shuijingwaimai.pojo.Employee;
import org.shuijing.shuijingwaimai.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.time.LocalDateTime;

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

    /**
     * requestbody :指的是前端传过来的
     *
     * @param request
     * @param employee
     * @return
     */
    @PostMapping("/login")
    public Result<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {
        //页面提交的代码进行md5加密
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        //根据页面提交的用户名查询数据库
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
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
        request.getSession().setAttribute("employee", emp.getId());

        return Result.success(emp);

    }

    /**
     * 员工退出
     *
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request) {
        //清理Session中的员工id、
        request.getSession().removeAttribute("employee");
        return Result.success("退出成功");
    }

    /**
     * 新增员工
     *
     * @return
     */
    @PostMapping
    public Result<String> save(HttpServletRequest request,  @RequestBody Employee employee) {

        System.out.println("employee " + employee.toString());

        employee.setPassword(DigestUtils.md5DigestAsHex("134652".getBytes()));
        employee.setCreateTime(LocalDateTime.now());
        employee.setUpdateTime(LocalDateTime.now());

        //获得当前登录用户的id
        Long empID = (Long) request.getSession().getAttribute("employee");
        employee.setCreateUser(empID);
        employee.setUpdateUser(empID);

        employeeService.save(employee);

        return Result.success("新增员工成功！");
    }

}





