package com.example.bakkatest.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private float totalSumm;

    private Date date;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderedProducts> orderedProducts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderedProducts> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<OrderedProducts> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public float getTotalSumm() {
        return totalSumm;
    }

    public void setTotalSumm(float totalSumm) {
        this.totalSumm = totalSumm;
    }
}
