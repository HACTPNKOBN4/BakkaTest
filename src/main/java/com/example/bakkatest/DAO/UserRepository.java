package com.example.bakkatest.DAO;

import com.example.bakkatest.entities.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepository {

    @PersistenceContext
    EntityManager em ;


    public void addUser(User user){
        em.persist(user);
    }

    public void deleteUser(User user){
        em.remove(user);
    }

    public String checkPassword(@Param("log") String log){
        Query q = em.createQuery("select u from User u where u.login =  '"+log+"'");
        List<User> result = q.getResultList();
        if(result.isEmpty())return null;
        else return result.stream().findAny().get().getPassword();

    }

    public String getUserInfo(int userId){
        TypedQuery<User> q = em.createQuery("select u from User u where u.id =  '"+userId+"'",User.class);
        if(q.equals(null))return null;
        User user = q.getSingleResult();
        return  "login: "+user.getLogin()+" fullname: "+user.getFullname();
    }

    public User findByLogin(String login){
        List<User> result = em.createQuery("select u from User u where u.login = '"+login+"'").getResultList();
        if(result.isEmpty())return null;
        return result.get(0);
    }
}
