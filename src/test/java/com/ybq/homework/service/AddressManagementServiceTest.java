package com.ybq.homework.service;

import com.ybq.homewok.entity.User;
import com.ybq.homewok.service.AddressManagementService;
import com.ybq.homewok.service.impl.AddressManagementServiceImpl;
import org.junit.Test;

public class AddressManagementServiceTest {
    private AddressManagementService service = new AddressManagementServiceImpl();
    @Test
    public void getData(){
        User data = service.getData(1);
        System.out.println(data);
    }
    @Test
    public void ss(){
    }
}
