package com.ybq.homewok.mapper;

import com.ybq.homewok.entity.Address;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper {

    /**
     * 添加地址信息
     *
     * @param address 地址信息
     * @return 影响行数
     */
    int insertAddress(@Param("address") Address address);

    /**
     * 更新地址信息
     *
     * @param address 地址对象
     * @return 影响行数
     */
    int updateAddress(@Param("address") Address address);

    /**
     * 根据地址id删除地址信息
     *
     * @param addressId 地址id
     * @return 影响行数
     */
    int deleteAddressById(@Param("addressId") int addressId);

    /**
     * 根据用户id修改地址的状态 全部修改为非默认状态（0表示非默认状态 1表示默认状态）
     *
     * @param userId 用户id
     * @return 影响行数
     */
    int updateStatusByUserId(@Param("userId") int userId);

    /**
     * 根据地址id修改地址的状态
     *
     * @param addressId 地址id
     * @param status    状态值 0表示非默认状态 1表示默认状态
     * @return 影响行数
     */
    int updateStatusById(@Param("addressId") int addressId, @Param("status") int status);
}
