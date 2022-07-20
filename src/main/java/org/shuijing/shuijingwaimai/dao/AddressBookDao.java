package org.shuijing.shuijingwaimai.dao;

import org.shuijing.shuijingwaimai.pojo.AddressBook;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 地址管理 Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2022-07-20
 */
@Mapper
public interface AddressBookDao extends BaseMapper<AddressBook> {

}
