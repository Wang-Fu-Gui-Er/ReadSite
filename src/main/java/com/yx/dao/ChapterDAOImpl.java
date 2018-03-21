package com.yx.dao;

import com.yx.po.Chapter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.sql.Blob;
import java.util.List;

public class ChapterDAOImpl {
    private Configuration configuration;
    private SessionFactory sessionFactory;

    public ChapterDAOImpl() {
        this.configuration = new Configuration().configure("hibernate.cfg.xml");
        this.sessionFactory = configuration.buildSessionFactory();
    }
    public List<Chapter> queryChapterByBookId(long bookId){
        Session session = sessionFactory.openSession();
        try {
            Query<Chapter> query = session.createQuery("from Chapter where book.bookId =:bookId order by chapId");
            query.setLong("bookId",bookId);
            List<Chapter> list = query.getResultList();
            if (list.size()!=0){
                return list;
            } else {
                return null;
            }
        } finally {
            session.close();
        }
    }

    public Chapter queryChapterByChapId(long chapId){
        Session session = sessionFactory.openSession();
        try {
            Query<Chapter> query = session.createQuery("from Chapter where chapId =:chapId");
            query.setLong("chapId",chapId);
            List<Chapter> list = query.getResultList();
            if (list.size()!=0){
                return list.iterator().next();
            } else {
                return null;
            }
        } finally {
            session.close();
        }
    }
    public Chapter queryPreByChapId(long chapId){
        Session session = sessionFactory.openSession();
        try {
            Chapter thisChap = queryChapterByChapId(chapId);
            long thisTitleId = thisChap.getChapTitleId();
            if (thisTitleId != -1){
                long preTitleId = thisTitleId - 1;
                long bookId = thisChap.getBook().getBookId();
                Query<Chapter> query = session.createQuery("from Chapter where chapTitleId =:preTitleId and "
                             +"book.bookId =:bookId");
                query.setLong("preTitleId",preTitleId);
                query.setLong("bookId",bookId);
                List<Chapter> list = query.getResultList();
                if (list.size()!=0){
                    return list.iterator().next();
                } else {
                    return null;
                }
            } else {    //第0章
                    return null;
            }
        } finally {
            session.close();
        }
    }

    public Chapter queryNextByChapId(long chapId){
        Session session = sessionFactory.openSession();
        try {
            Chapter thisChap = queryChapterByChapId(chapId);
            long thisTitleId = thisChap.getChapTitleId();
            long maxTitleId = thisChap.getBook().getChapCount();
            if (thisTitleId != maxTitleId-1){ //不是最后一章
                long nextTitleId = thisTitleId + 1;
                long bookId = thisChap.getBook().getBookId();
                Query<Chapter> query = session.createQuery("from Chapter where chapTitleId =:nextTitleId and "
                        +"book.bookId =:bookId");
                query.setLong("nextTitleId",nextTitleId);
                query.setLong("bookId",bookId);
                List<Chapter> list = query.getResultList();
                if (list.size()!=0){
                    return list.iterator().next();
                } else {
                    return null;
                }
            } else {    //是最后一章
                return null;
            }
        } finally {
            session.close();
        }
    }

}
