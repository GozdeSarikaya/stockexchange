package hibernate.manager;

import hibernate.tables.User;
import hibernate.view.User.EditUserView;
import hibernate.view.User.SaveUserView;
import utility.EntityManagerUtility;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
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
        List<User> users = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            String sql = "select * from User";
            users = entityManager.createQuery("select * from User").getResultList();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return users;
    }
}
