package com.yx.service;

import com.yx.dao.BookDAOImpl;
import com.yx.po.Book;

import java.util.List;

public class BookService {
    private BookDAOImpl dao;

    public BookService() {
        dao = new BookDAOImpl();
    }
    public List<Book> queryBookByBigCateId(long bigCateId,int page){
        return dao.queryBookByBigCateId(bigCateId,page);
    }
    public Book queryBookByBookId(long bookId){
        return dao.queryBookByBookId(bookId);
    }
    public List<Book> queryBookBySmallCateId(long smallCateId,int page){
        return dao.queryBookBySmallCateId(smallCateId,page);
    }
    public int queryBookCount(long smallCateId,long bigCateId){
        return dao.queryBookCount(smallCateId,bigCateId);
    }
}
