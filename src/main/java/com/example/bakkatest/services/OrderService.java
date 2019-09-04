package com.example.bakkatest.services;

import com.example.bakkatest.entities.Order;
import com.example.bakkatest.entities.OrderedProducts;
import com.example.bakkatest.entities.Product;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderService extends com.example.bakkatest.services.Service {


    public Iterable<Order> getOrders(){
        return bakkaRepository.getOrderList(findCurrenUser().getId());
    }

    public void createOrder(Set<OrderedProducts> products, Order order){
        bakkaRepository.addOrderedProducts(products);
        bakkaRepository.addOrder(order);
    }

    public Iterable<Product> getProducts(){
        return bakkaRepository.getProductList();
    }
}
