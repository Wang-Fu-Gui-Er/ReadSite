package com.yx.dao;

import com.yx.po.Myuser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class MyUserDAOImpl {
    private Configuration configuration;
    private SessionFactory sessionFactory;

    public MyUserDAOImpl() {
        this.configuration = new Configuration().configure("hibernate.cfg.xml");
        this.sessionFactory = configuration.buildSessionFactory();
    }

    public boolean addUser(Myuser myuser){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            session.save(myuser);
            transaction.commit();
            return true;
        } catch (Exception e){
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }
    public boolean queryByUserName(String userName){
        Session session = sessionFactory.openSession();
        Query<Myuser> query = session.createQuery("from Myuser where userName =:name");
        query.setString("name",userName);
        List<Myuser> list = query.getResultList();
        session.close();
        if (list.size()==0){
            return true;    //没有重名
        } else {
            return false; //用户名已存在
        }
    }
    public boolean queryForPwd(String userName,String userPwd){ //登录验证
        Session session = sessionFactory.openSession();
        Query<Myuser> query = session.createQuery("from Myuser where userName =:name");
        query.setString("name",userName);
        List<Myuser> list = query.getResultList();
        if ((userPwd.equals(list.iterator().next().getUserPwd())) && list.size()==1){
            return true;
        } else {
            return false;
        }
    }

    public Myuser queryMyuser(String userName){
        Session session = sessionFactory.openSession();
        Query<Myuser> query = session.createQuery("from Myuser where userName =:name");
        query.setString("name",userName);
        List<Myuser> list = query.getResultList();
        session.close();
        return list.iterator().next();
    }
}
