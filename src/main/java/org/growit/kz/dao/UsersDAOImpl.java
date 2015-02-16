package org.growit.kz.dao;

import org.growit.kz.model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Администратор on 10.11.2014.
 */

@Repository
public class UsersDAOImpl implements UserDAO {



    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory= sessionFactory;
    }

    public Session currentSession(){
        return sessionFactory.getCurrentSession();
    }




    @Override
    public List<Users> getAllRecordsUserEntity() {
        return currentSession().createQuery("from Users c").list();
    }

    @Override
    public void addRecordsUsers(Users usersEntity) {
        currentSession().saveOrUpdate(usersEntity);
    }

    @Override
    public void deleteRecordUsers(Users usersEntity) {
        currentSession().delete(usersEntity);
    }

    @Override
    public Users findByIdUser(int id) {
        Users usersEntity= (Users)currentSession().createQuery("from Users c where c.id =:id").setParameter("id", id).uniqueResult();
        System.out.println("looking for user with ID: " + id);
        System.out.println(usersEntity);
        return usersEntity;
    }

    @Override
    public String updateRecordsUsers(Users usersEntity) {
        currentSession().saveOrUpdate(usersEntity);
        ResourceBundle bundle = null;
        try {
            bundle = ResourceBundle.getBundle("resources.messages.messages", Locale.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  bundle.getString("UpdateRows");
    }
}
