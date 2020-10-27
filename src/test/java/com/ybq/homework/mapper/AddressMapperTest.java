package com.ybq.homework.mapper;

import com.ybq.homewok.entity.Address;
import com.ybq.homewok.mapper.AddressMapper;
import com.ybq.homewok.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressMapperTest {
    SqlSession sqlSession;
    AddressMapper mapper;

    @Before
    public void before(){
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(UserMapperTest.class.getClassLoader().getResourceAsStream("mybatis-config.xml"));
        sqlSession = factory.openSession(true);
        mapper = sqlSession.getMapper(AddressMapper.class);
    }
    @After
    public void after(){
        sqlSession.close();
    }

    @Test
    public void insertAddress(){
        Address address = new Address();
        address.setUserId(1);
        address.setRecipientPhone("10086");
        address.setAddressProvince("广西");
        address.setAddressCity("北海市");
        address.setAddressCounty("银海区");
        address.setAddressDetailed("南珠大道9号(桂林电子科技大学北海校区)");
        address.setRecipientName("渣渣辉");
        int i = mapper.insertAddress(address);
        System.out.println(i);
    }
    @Test
    public void updateAddress(){
        Address address = new Address();
        address.setAddressId(2);
        address.setUserId(1);
        address.setRecipientPhone("123456789");
        address.setAddressProvince("广西");
        address.setAddressCity("北海市");
        address.setAddressCounty("银海区");
        address.setAddressDetailed("南珠大道99号(桂林电子科技大学北海校区)");
        address.setRecipientName("301");
        System.out.println(mapper.updateAddress(address));
    }
    @Test
    public void deleteAddressById(){
        System.out.println(mapper.deleteAddressById(2));
    }
    @Test
    public void updateStatusById(){
        System.out.println(mapper.updateStatusById(2, 1));
    }
    @Test
    public void updateStatusByUserId(){
        System.out.println(mapper.updateStatusByUserId(1));
    }
}
