package com.netas.interview.hibernate.manager;

import com.netas.interview.hibernate.tables.User;
import com.netas.interview.hibernate.view.user.EditUserView;
import com.netas.interview.hibernate.view.user.SaveUserView;
import com.netas.interview.utility.EntityManagerUtility;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private EntityManager entityManager = EntityManagerUtility.getEntityManager();


    public User saveUser(SaveUserView userView) {
        User user = new User();
        try {
            entityManager.getTransaction().begin();
            user.setEmail(userView.getEmail());
            user.setLoginname(userView.getLoginname());
            user.setProfilename(userView.getProfilename());
            user.setCreateddate(new Timestamp(System.currentTimeMillis()));
            user.setLastmodifieddate(new Timestamp(System.currentTimeMillis()));
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return user;
    }


    public void deleteUser(int userid) {
        try {
            entityManager.getTransaction().begin();
            User student = (User) entityManager.find(User.class, userid);
            entityManager.remove(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

    }

    public User getUser(int userid) {
        User user = new User();
        try {
            entityManager.getTransaction().begin();
            user = (User) entityManager.find(User.class, userid);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return user;
    }

    public void editUser(EditUserView editUserView) {
        try {
            entityManager.getTransaction().begin();
            User user = (User) entityManager.find(User.class, editUserView.getId());
            user.setLoginname(editUserView.getLoginname());
            user.setPassword(editUserView.getPassword());
            user.setLastmodifieddate(new Timestamp(System.currentTimeMillis()));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
             userList = entityManager.createQuery("Select e from User e").getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return userList;
    }
}
