package com.ybq.homewok.service.impl;

import com.ybq.homewok.entity.Address;
import com.ybq.homewok.entity.User;
import com.ybq.homewok.mapper.AddressMapper;
import com.ybq.homewok.mapper.UserMapper;
import com.ybq.homewok.service.AddressManagementService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class AddressManagementServiceImpl implements AddressManagementService {
    private UserMapper userMapper;
    private AddressMapper addressMapper;
    public static final int STATUS_DEFAULT = 1;
    public static final int STATUS_UNDEFAULT = 0;

    public AddressManagementServiceImpl() {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(AddressManagementServiceImpl.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = factory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
        addressMapper = sqlSession.getMapper(AddressMapper.class);
    }

    @Override
    public User getData(int userId) {
        return userMapper.selectUserByUserId(userId);
    }

    @Override
    public User deleteAddress(int addressId, int userId) {
        int i = addressMapper.deleteAddressById(addressId);
        return getData(userId);
    }

    @Override
    public User addAddress(Address address, int userId) {
        int i = addressMapper.insertAddress(address);
        return getData(userId);
    }

    @Override
    public User setDefaultAddress(int addressId, int userId) {
        addressMapper.updateStatusByUserId(userId);
        addressMapper.updateStatusById(addressId,STATUS_DEFAULT);
        return getData(userId);
    }
}