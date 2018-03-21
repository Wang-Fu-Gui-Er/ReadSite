package com.yx.service;

import com.yx.dao.MyUserDAOImpl;
import com.yx.po.Myuser;

public class MyUserService {
    private MyUserDAOImpl dao;

    public MyUserService() {
        dao = new MyUserDAOImpl();
    }

    public boolean addUser(Myuser myuser){
        return dao.addUser(myuser);
    }

    public boolean queryByUserName(String userName){
        return dao.queryByUserName(userName);
    }
    public boolean queryForPwd(String userName,String userPwd){
        return dao.queryForPwd(userName,userPwd);
    }
    public Myuser queryMyuser(String userName){
        return dao.queryMyuser(userName);
    }
}
