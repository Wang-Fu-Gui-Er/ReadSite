package com.yx.control;

import com.yx.po.Chapter;
import com.yx.service.ChapterService;

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
import java.util.List;
import java.util.Map;

@WebServlet( name = "chapterControl",urlPatterns = {"/chapter"},
        initParams = {
                @WebInitParam(name = "show",value = "show.jsp"),
        }
)
public class ChapterControl extends HttpServlet {
    private Map<String,String> map;
    private ChapterService service;

    public ChapterControl() {
        map = new HashMap<String, String>();
        service = new ChapterService();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        map.put("show",config.getInitParameter("show"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String chapType = req.getParameter("chapType");
        if (chapType.equals("chapBookId")){
            String h_bookId = req.getParameter("bookId");
            long bookId = Long.parseLong(h_bookId);
            List<Chapter> listChapter = service.queryChapterByBookId(bookId);
            if (listChapter == null){
                req.getSession().setAttribute("listChapter",null);
            } else {
                req.getSession().setAttribute("listChapter",listChapter);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher(map.get("show")+"?msgFlag=left");
            dispatcher.forward(req,resp);
        } else if (chapType.equals("onlyChapId")){
            String h_chapId = req.getParameter("chapId");
            long chapId = Long.parseLong(h_chapId);
            Chapter thisChap = service.queryChapterByChapId(chapId);
            Chapter preChap = service.queryPreByChapId(chapId);
            Chapter nextChap = service.queryNextByChapId(chapId);
            if (thisChap == null) {
                req.setAttribute("chapterAll",null);
                req.setAttribute("preChap",preChap);
                req.setAttribute("nextChap",nextChap);
            } else {
                req.setAttribute("chapterAll",thisChap);
                req.setAttribute("preChap",preChap);
                req.setAttribute("nextChap",nextChap);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher(map.get("show")+"?msgFlag=right");
            dispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

}
