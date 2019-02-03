package com.netas.interview.hibernate.manager;

import com.netas.interview.hibernate.tables.Profile;
import com.netas.interview.hibernate.tables.User;
import com.netas.interview.hibernate.view.User.EditUserView;
import com.netas.interview.hibernate.view.User.SaveUserView;
import com.netas.interview.utility.EntityManagerUtility;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private EntityManager entityManager = EntityManagerUtility.getEntityManager();


    public User saveUser(SaveUserView userView) {
        User user = new User();
        SaveUserView userViews = new SaveUserView();
        try {
            entityManager.getTransaction().begin();
            userViews.setEmail(userView.getEmail());
            userViews.setLoginname(userView.getLoginname());
            userViews.setProfilename(userView.getProfilename());
            userViews.setCreateddate(new Timestamp(System.currentTimeMillis()));
            userViews.setLastmodifieddate(new Timestamp(System.currentTimeMillis()));
            user = entityManager.merge(user);
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
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return user;
    }

    public void editUser(EditUserView editUserView) {
        try {
            entityManager.getTransaction().begin();
            User user = (User) entityManager.find(User.class, editUserView.getLoginname());
            user.setLoginname(editUserView.getLoginname());
            user.setPassword(editUserView.getPassword());
            user.setLastmodifieddate(new Timestamp(System.currentTimeMillis()));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    public List<User> getUserList() {
        List users = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            List<User> listPersons = entityManager.createQuery("SELECT p FROM User p").getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();

            if (listPersons == null || listPersons.size()==0) {
                System.out.println("No persons found . ");
            } else {
                for (User person : listPersons) {
                    System.out.print("Person name= " + person.getLoginname());
                }
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return users;
    }
}
