package com.yx.service;

import com.yx.dao.ChapterDAOImpl;
import com.yx.po.Chapter;

import java.util.List;

public class ChapterService {
    private ChapterDAOImpl dao;

    public ChapterService() {
        dao = new ChapterDAOImpl();
    }

    public List<Chapter> queryChapterByBookId(long bookId){
        return dao.queryChapterByBookId(bookId);
    }

    public Chapter queryChapterByChapId(long chapId){
        return dao.queryChapterByChapId(chapId);
    }
    public Chapter queryPreByChapId(long chapId){
        return dao.queryPreByChapId(chapId);
    }
    public Chapter queryNextByChapId(long chapId){
        return dao.queryNextByChapId(chapId);
    }
}
