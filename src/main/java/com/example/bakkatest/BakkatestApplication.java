package com.example.bakkatest;


import com.example.bakkatest.DAO.BakkaRepository;
import com.example.bakkatest.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.SQLOutput;


@SpringBootApplication
public class BakkatestApplication  implements CommandLineRunner {

    @Autowired
    public BakkaRepository repository ;


    public static void main(String[] args) {
        ApplicationContext applicationContext =
                SpringApplication.run(BakkatestApplication.class, args);
    }

    public void run(String... strings)throws Exception{
        for(Order o: repository.getOrderList(1)){
            System.out.println(o.getTotalSumm());
        }
        System.out.println("============================");
        System.out.println(1+'0');
        //"adf".toUpperCase().sub;
    }

}
