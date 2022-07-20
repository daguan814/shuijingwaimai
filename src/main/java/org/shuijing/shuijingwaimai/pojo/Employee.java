package org.shuijing.shuijingwaimai.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 员工信息
 * </p>
 *
 * @author baomidou
 * @since 2022-07-20
 */
@Getter
@Setter
@TableName("employee")
@ApiModel(value = "Employee对象", description = "员工信息")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId("id")
    private Long id;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    @TableField("password")
    private String password;

    @ApiModelProperty("手机号")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("性别")
    @TableField("sex")
    private String sex;

    @ApiModelProperty("身份证号")
    @TableField("id_number")
    private String idNumber;

    @ApiModelProperty("状态 0:禁用，1:正常")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("创建人")
    @TableField("create_user")
    private Long createUser;

    @ApiModelProperty("修改人")
    @TableField("update_user")
    private Long updateUser;


}
