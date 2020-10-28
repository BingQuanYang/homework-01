package com.ybq.homewok.controller;

import com.ybq.homewok.entity.Address;
import com.ybq.homewok.entity.User;
import com.ybq.homewok.resp.Message;
import com.ybq.homewok.resp.ResponseEntity;
import com.ybq.homewok.resp.Status;
import com.ybq.homewok.service.AddressManagementService;
import com.ybq.homewok.service.impl.AddressManagementServiceImpl;
import com.ybq.homewok.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddressManagementController")
public class AddressManagementController extends HttpServlet {
    private AddressManagementService service = new AddressManagementServiceImpl();
    public static final String ACTION = "action";
    public static final String GET_DATA = "getData";
    public static final String DELETE_ADDRESS = "deleteAddress";
    public static final String ADD_ADDRESS = "addAddress";
    public static final String SET_DEFAULT_ADDRESS = "setDefaultAddress";
    public static final String USER_ID = "userId";
    public static final String ADDRESS_ID = "addressId";
    public static final String RECIPIENT_NAME = "recipientName";
    public static final String RECIPIENT_PHONE = "recipientPhone";
    public static final String ADDRESS_PROVINCE = "addressProvince";
    public static final String ADDRESS_CITY = "addressCity";
    public static final String ADDRESS_COUNTY = "addressCounty";
    public static final String ADDRESS_DETAILED = "addressDetailed";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ResponseEntity entity = new ResponseEntity();
        try {
            String action = request.getParameter(ACTION);
            String userId = null;
            String addressId = null;
            String recipientName = null;
            String recipientPhone = null;
            String addressProvince = null;
            String addressCity = null;
            String addressCounty = null;
            String addressDetailed = null;
            switch (action) {
                case GET_DATA:
                    //获取用户id
                    userId = request.getParameter(USER_ID);
                    //判断
                    if (userId != null) {
                        //获取数据
                        User data = service.getData(Integer.valueOf(userId));
                        entity.setData(data);
                        entity.setMsg(Message.SUCCESS);
                        entity.setStatus(Status.SUCCESS);
                    } else {
                        entity.setMsg(Message.ERROR);
                        entity.setStatus(Status.ERROR);
                    }
                    break;
                case ADD_ADDRESS:
                    //获取用户id
                    userId = request.getParameter(USER_ID);
                    //判断
                    if (userId != null) {
                        //如果不等于Null
                        //从请求中获取数据
                        recipientName = request.getParameter(RECIPIENT_NAME);
                        recipientPhone = request.getParameter(RECIPIENT_PHONE);
                        addressProvince = request.getParameter(ADDRESS_PROVINCE);
                        addressCity = request.getParameter(ADDRESS_CITY);
                        addressCounty = request.getParameter(ADDRESS_COUNTY);
                        addressDetailed = request.getParameter(ADDRESS_DETAILED);
                        //封装JavaBean
                        Address address = new Address();
                        address.setUserId(Integer.valueOf(userId));
                        address.setRecipientName(recipientName);
                        address.setRecipientPhone(recipientPhone);
                        address.setAddressProvince(addressProvince);
                        address.setAddressCity(addressCity);
                        address.setAddressCounty(addressCounty);
                        address.setAddressDetailed(addressDetailed);
                        //添加地址信息，并获取数据
                        User data = service.addAddress(address, Integer.valueOf(userId));
                        entity.setData(data);
                        entity.setMsg(Message.SUCCESS);
                        entity.setStatus(Status.SUCCESS);
                    } else {
                        entity.setMsg(Message.ERROR);
                        entity.setStatus(Status.ERROR);
                    }
                    break;
                case SET_DEFAULT_ADDRESS:
                    addressId = request.getParameter(ADDRESS_ID);
                    userId = request.getParameter(USER_ID);
                    if (addressId != null && userId != null) {
                        User data = service.setDefaultAddress(Integer.valueOf(addressId), Integer.valueOf(userId));
                        entity.setData(data);
                        entity.setMsg(Message.SUCCESS);
                        entity.setStatus(Status.SUCCESS);
                    } else {
                        entity.setMsg(Message.ERROR);
                        entity.setStatus(Status.ERROR);
                    }
                    break;
                case DELETE_ADDRESS:
                    addressId = request.getParameter(ADDRESS_ID);
                    userId = request.getParameter(USER_ID);
                    if (addressId != null && userId != null) {
                        User data = service.deleteAddress(Integer.valueOf(addressId), Integer.valueOf(userId));
                        entity.setData(data);
                        entity.setMsg(Message.SUCCESS);
                        entity.setStatus(Status.SUCCESS);
                    }else {
                        entity.setMsg(Message.ERROR);
                        entity.setStatus(Status.ERROR);
                    }
                    break;
                default:
                    entity.setMsg(Message.ERROR);
                    entity.setStatus(Status.ERROR);
                    break;

            }

        } catch (Exception e) {
            entity.setMsg(Message.ERROR);
            entity.setStatus(Status.ERROR);
        } finally {
            ResponseUtils.responseToJson(response, entity);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
