package com.example.bakkatest.DAO;


import com.example.bakkatest.entities.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;


@Repository
@Transactional
public class BakkaRepository {

    @PersistenceContext
    EntityManager em ;


    public String checkPassword(@Param("log") String log){
        Query q = em.createQuery("select u from User u where u.login =  '"+log+"'");
        List<User> result = q.getResultList();
        if(result.isEmpty())return null;
            else return result.stream().findAny().get().getPassword();
    }

    public List<Product> getProductList(){
        return  em.createQuery("select p from Product p")
                    .getResultList();
    }

    public List<Order> getOrderList(int userId){
        return em.createQuery("select o from Order o where o.user.id = "+userId).getResultList();
    }

    public void addOrder(Order order){
        em.persist(order);
    }

    public void addOrderedProducts(Set<OrderedProducts> orderedProducts){
        for(OrderedProducts op:orderedProducts){
            em.persist(op);
        }
    }
}
