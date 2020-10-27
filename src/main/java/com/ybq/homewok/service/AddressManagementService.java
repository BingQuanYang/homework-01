package com.ybq.homewok.service;

import com.ybq.homewok.entity.Address;
import com.ybq.homewok.entity.User;

public interface AddressManagementService {
    /**
     * 根据用户id获取地址信息列表
     *
     * @param userId 用户id
     * @return user对象 封装了地址列表
     */
    User getData(int userId);

    /**
     * 根据地址id删除地址信息，删除过后根据用户id查询地址信息列表并返回
     *
     * @param addressId 地址id
     * @param userId    用户id
     * @return user对象 封装了地址列表
     */
    User deleteAddress(int addressId, int userId);

    /**
     * 添加地址信息，添加过后根据用户id查询地址信息列表并返回
     *
     * @param address 地址信息
     * @param userId  用户id
     * @return user对象 封装了地址列表
     */
    User addAddress(Address address, int userId);

    /**
     * 根据地址id设置默认地址，并根据用户id查询地址信息列表进行返回
     *
     * @param addressId 地址ID
     * @param userId    用户id
     * @return user对象 封装了地址列表
     */
    User setDefaultAddress(int addressId, int userId);
}
