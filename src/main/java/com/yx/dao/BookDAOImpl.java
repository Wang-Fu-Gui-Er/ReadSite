package com.yx.dao;

import com.yx.po.BigCategory;
import com.yx.po.Book;
import com.yx.po.Myuser;
import com.yx.po.SmallCategory;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.Query;
import org.junit.Test;

import javax.persistence.ParameterMode;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookDAOImpl {
    private Configuration configuration;
    private SessionFactory sessionFactory;

    public BookDAOImpl() {
        this.configuration = new Configuration().configure("hibernate.cfg.xml");
        this.sessionFactory = configuration.buildSessionFactory();
    }

//    public List<Book> queryBookByBigCateId(long bigCateId){
//        List<Book> listResult = new ArrayList<Book>();
//        Session session = sessionFactory.openSession();
//        Query querySmall =  session.createQuery("select smallCateId from SmallCategory" +
//                " where bigCategory.bigCateId =:bigCateId");
//        querySmall.setLong("bigCateId",bigCateId);
//        Query queryBook =  session.createQuery("from Book where " +
//                "smallCategory =:smallCateId");
//
//        List<Long> listSmall = querySmall.getResultList();
//        Iterator<Long> iteratorSmall = listSmall.iterator();
//        while (iteratorSmall.hasNext()){
//            long smallCateId = iteratorSmall.next();//smallCateId
//            queryBook.setLong("smallCateId",smallCateId);
//            List<Book> listBook = queryBook.getResultList();
//            listResult.addAll(listBook);
//        }
//        return listResult;
//     }
//    public List<Book> queryBookBySmallCateId(long smallCateId){
//        List<Book> listResult = new ArrayList<Book>();
//        Session session = sessionFactory.openSession();
//        Query queryBook =  session.createQuery("from Book where " +
//                "smallCategory =:smallCateId");
//        queryBook.setLong("smallCateId",smallCateId);
//        List<Book> listBook = queryBook.getResultList();
//        listResult.addAll(listBook);
//        return listResult;
//    }

     public Book queryBookByBookId(long bookId){
         Session session = sessionFactory.openSession();
         Query query =  session.createQuery("from Book where bookId =:bookId");
         query.setLong("bookId",bookId);
         List<Book> list = query.getResultList();
         if (list.size()==1 && list.iterator().hasNext()){
             return list.iterator().next();
         } else {
             return null;
         }
     }
//@Test
//public void test1(){
//    System.out.println(queryBookCount(-1L,5L));
//}
    public int queryBookCount(long smallCateId,long bigCateId){
        Session session = sessionFactory.openSession();
        ProcedureCall call = session.createStoredProcedureCall("proc_book_count");
        call.registerParameter("p_small_cate_id",Long.class,ParameterMode.IN).bindValue(smallCateId);
        call.registerParameter("p_big_cate_id",Long.class,ParameterMode.IN).bindValue(bigCateId);
        call.registerParameter("p_book_count",Integer.class,ParameterMode.OUT);
        int result = (int)call.getOutputs().getOutputParameterValue("p_book_count");
        return result;
     }
    public List<Book> queryBookByBigCateId(long bigCateId,int page){
        Session session = sessionFactory.openSession();
        Query<Book> query = session.createQuery("from Book as b where " +
                "b.smallCategory.bigCategory.bigCateId =:bigCateId");
        query.setLong("bigCateId",bigCateId);
//        ScrollableResults scroll = query.scroll();
//        scroll.last();//滚动到最后一行
//        int n = scroll.getRowNumber() + 1;//总记录数
        int pageSize = 24;//每页的记录条数
        int pageNo = page;//当前页号
        query.setFirstResult((pageNo-1)*pageSize);//指定从哪一条记录开始检索
        query.setMaxResults(pageSize);//指定一次最多检索记录条数
        List<Book> list = query.list();
        return list;
    }

    public List<Book> queryBookBySmallCateId(long smallCateId,int page){
        Session session = sessionFactory.openSession();
        Query query =  session.createQuery("from Book where " +
                "smallCategory =:smallCateId");
        query.setLong("smallCateId",smallCateId);
        int pageSize = 24;//每页的记录条数
        int pageNo = page;//当前页号
        query.setFirstResult((pageNo-1)*pageSize);//指定从哪一条记录开始检索
        query.setMaxResults(pageSize);//指定一次最多检索记录条数
        List<Book> list = query.list();
        return list;
    }

}