package com.yx.control;

import com.yx.po.Myuser;
import com.yx.service.MyUserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UserControl", urlPatterns = {"/user"},initParams = {
        @WebInitParam(name = "login",value = "login.jsp"),
        @WebInitParam(name = "register", value = "register.jsp"),
        @WebInitParam(name = "index",value = "index.jsp")
})
public class UserControl extends HttpServlet {
    private MyUserService service;
    private Map<String,String> target;

    public UserControl() {
        service = new MyUserService();
        target = new HashMap<String, String>();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        target.put("login",config.getInitParameter("login"));
        target.put("register",config.getInitParameter("register"));
        target.put("index",config.getInitParameter("index"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("logout")){
            req.getSession().setAttribute("user",null);
            RequestDispatcher dispatcher = req.getRequestDispatcher(target.get("index"));
            dispatcher.forward(req,resp);
        } else {
            this.doPost(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String userName = req.getParameter("userName");
        String userPwd = req.getParameter("userPwd");
        if (action.equals("register")){ //注册
            String userEmail = req.getParameter("userEmail");
            Myuser myuser = new Myuser();
            myuser.setUserName(userName);
            myuser.setUserPwd(userPwd);
            myuser.setUserEmail(userEmail);
            if (service.queryByUserName(userName)){ //用户名不存在，可增加
                if (service.addUser(myuser)) { //注册成功
                    req.setAttribute("regMsg","注册成功，请登录");
                    RequestDispatcher dispatcher = req.getRequestDispatcher(target.get("register"));
                    dispatcher.forward(req,resp);
                } else {    //注册失败
                    req.setAttribute("regMsg","注册失败");
                    RequestDispatcher dispatcher = req.getRequestDispatcher(target.get("register"));
                    dispatcher.forward(req,resp);
                }
            } else {    //用户名已存在，无法添加
                req.setAttribute("regMsg","用户名已存在，注册失败");
                RequestDispatcher dispatcher = req.getRequestDispatcher(target.get("register"));
                dispatcher.forward(req,resp);
            }
        } else if (action.equals("login")){ //登录
            if (service.queryForPwd(userName,userPwd)){ //登录成功
                Myuser user = service.queryMyuser(userName);
                req.getSession().setAttribute("user",user);
                RequestDispatcher dispatcher = req.getRequestDispatcher(target.get("index"));
                dispatcher.forward(req,resp);
            } else {
                req.setAttribute("regMsg","登录失败，请重新登录");
                RequestDispatcher dispatcher = req.getRequestDispatcher(target.get("login"));
                dispatcher.forward(req,resp);
            }
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
