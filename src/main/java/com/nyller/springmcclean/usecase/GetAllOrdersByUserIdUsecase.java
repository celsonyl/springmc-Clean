package com.nyller.springmcclean.usecase;

import com.nyller.springmcclean.domain.OrderDomain;
import com.nyller.springmcclean.domain.exceptions.ObjectNotFoundException;
import com.nyller.springmcclean.gateway.GetAllOrdersByUserIdGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllOrdersByUserIdUsecase {

    @Autowired
    private GetAllOrdersByUserIdGateway getAllOrdersByUserIdGateway;

    public List<OrderDomain> execute(Integer id) {
        List<OrderDomain> orderList = getAllOrdersByUserIdGateway.execute(id);

        if (orderList.isEmpty()) {
            throw new ObjectNotFoundException("this user don't have order");
        }

        return orderList;
    }
}