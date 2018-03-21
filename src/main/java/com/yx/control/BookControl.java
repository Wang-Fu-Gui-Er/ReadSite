package com.yx.control;

import com.yx.po.Book;
import com.yx.po.SmallCategory;
import com.yx.service.BookService;

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

@WebServlet( name = "bookControl",urlPatterns = {"/book"},
        initParams = {
            @WebInitParam(name = "list",value = "list.jsp"),
            @WebInitParam(name = "book",value = "book.jsp")
        }
)
public class BookControl extends HttpServlet {
    private Map<String,String> map;
    private BookService service;


    public BookControl() {
        map = new HashMap<String, String>();
        service = new BookService();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        map.put("list",config.getInitParameter("list"));
        map.put("book",config.getInitParameter("book"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if (type.equals("manyBook")) {
            String h_bigCateId = req.getParameter("bigCateId");
            String h_smallCateId = req.getParameter("smallCateId");
            String h_page = req.getParameter("page");
            int page = Integer.parseInt(h_page);
            int bookCount = 0;

            if (h_bigCateId != null && h_smallCateId == null){
                long bigCateId = Long.parseLong(h_bigCateId);
                List<Book> listBook = service.queryBookByBigCateId(bigCateId,page);
                bookCount = service.queryBookCount(-1,bigCateId);
                if (listBook.size()==0){    //没有查到书
                    req.setAttribute("bookResult",null);
                    req.setAttribute("currentPage",page);
                    req.setAttribute("small_cate_name",null);
                    req.setAttribute("small_cate_id",null);
                    req.setAttribute("bookCount",0);
                    RequestDispatcher dispatcher =
                            req.getRequestDispatcher(map.get("list")+"?bigCateId="+h_bigCateId);
                    dispatcher.forward(req,resp);
                } else { //查到书了
                    req.setAttribute("bookResult",listBook);
                    req.setAttribute("currentPage",page);
                    req.setAttribute("small_cate_name",null);
                    req.setAttribute("small_cate_id",null);
                    req.setAttribute("bookCount",bookCount);
                    RequestDispatcher dispatcher =
                            req.getRequestDispatcher(map.get("list")+"?bigCateId="+h_bigCateId);
                    dispatcher.forward(req,resp);
                }
            }
            if (h_bigCateId !=null && h_smallCateId != null){
                long smallCateId = Long.parseLong(h_smallCateId);
                List<Book> listBook = service.queryBookBySmallCateId(smallCateId,page);
                bookCount = service.queryBookCount(smallCateId,-1);
                if (listBook.size()==0){    //没有查到书
                    req.setAttribute("small_cate_name",null);
                    req.setAttribute("small_cate_id",smallCateId);
                    req.setAttribute("currentPage",page);
                    req.setAttribute("bookResult",null);
                    req.setAttribute("bookCount",0);
                } else { //查到书了;
                    String smallCate = listBook.iterator().next().getSmallCategory().getSmallCateName();
                    req.setAttribute("small_cate_name",smallCate);
                    req.setAttribute("small_cate_id",smallCateId);
                    req.setAttribute("currentPage",page);
                    req.setAttribute("bookResult",listBook);
                    req.setAttribute("bookCount",bookCount);
                }
                RequestDispatcher dispatcher =
                        req.getRequestDispatcher(map.get("list")+"?bigCateId="+h_bigCateId);
                dispatcher.forward(req,resp);
            }
        } else if (type.equals("oneBook")){
            String h_bookId = req.getParameter("bookId");
            long bookId = Long.parseLong(h_bookId);
            Book book = service.queryBookByBookId(bookId);
            if (book == null){
                req.setAttribute("rbook",null);
                RequestDispatcher dispatcher = req.getRequestDispatcher(map.get("book"));
                dispatcher.forward(req,resp);
            } else {
                req.setAttribute("rbook",book);
                RequestDispatcher dispatcher = req.getRequestDispatcher(map.get("book"));
                dispatcher.forward(req,resp);
            }
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
