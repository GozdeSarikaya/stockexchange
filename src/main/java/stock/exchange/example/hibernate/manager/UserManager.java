package stock.exchange.example.hibernate.manager;

import org.json.simple.JSONObject;
import stock.exchange.example.hibernate.tables.User;
import stock.exchange.example.hibernate.view.user.EditUserView;
import stock.exchange.example.hibernate.view.user.SaveUserView;
import stock.exchange.example.rest.authentication.JWTManager;
import stock.exchange.example.rest.authentication.UserSessionView;
import stock.exchange.example.utility.EntityManagerUtility;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserManager {


    public UserManager(UserSessionView userSessionView) {
        this.userSessionView = userSessionView;
    }


    private EntityManager entityManager = EntityManagerUtility.getEntityManager();
    private UserSessionView userSessionView;

    public User saveUser(SaveUserView userView) throws Exception {
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
            throw new Exception("User could not be saved!");
        }
        return user;
    }


    public void deleteUser(int userid) throws Exception {
        try {
            entityManager.getTransaction().begin();
            User student = (User) entityManager.find(User.class, userid);
            entityManager.remove(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("User " + userid + "could not be deleted!");

        }

    }

    public User getUser(int userid) throws Exception {
        User user;
        try {
            entityManager.getTransaction().begin();
            user = (User) entityManager.find(User.class, userid);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("User " + userid + " could not be list!");
        }
        return user;
    }

    public void editUser(EditUserView editUserView) throws Exception {
        List<User> userList;
        try {
            entityManager.getTransaction().begin();
            userList = entityManager.createQuery("Select e.id from User e where e.loginname='" + editUserView.getLoginname() + "'").getResultList();

            User user = (User) entityManager.find(User.class, userList.get(0));
            user.setLoginname(editUserView.getLoginname());
            user.setPassword(editUserView.getPassword());
            user.setLastmodifieddate(new Timestamp(System.currentTimeMillis()));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("User could not be edited!");

        }
    }

    public List<User> getUserList() throws Exception {
        List<User> userList = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            userList = entityManager.createQuery("Select e from User e").getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("User list could not be get!");
        }
        return userList;
    }

    public JSONObject validateUser(String loginname, String password) throws Exception {
        JSONObject jsonObject = new JSONObject();
        List<User> userList;
        try {
            entityManager.getTransaction().begin();
            userList = entityManager.createQuery("Select e from User e where e.loginname='" + loginname + "'").getResultList();
            entityManager.getTransaction().commit();

            if (userList.size() == 1)
                jsonObject.put("token", JWTManager.generateToken(userList.get(0).getLoginname(), userList.get(0).getProfilename()));
            else
                jsonObject.put("token", "");


        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Username/password is not valid!");
        }
        return jsonObject;


    }
}
