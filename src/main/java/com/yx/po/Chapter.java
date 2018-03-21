package com.yx.po;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Chapter implements Serializable {
    private long chapId;
    private Long chapTitleId;
    private String chapTitleName;
    private String chapContent;
    private Book book;

    @Id
    @Column(name = "CHAP_ID", nullable = false, precision = 0)
    public long getChapId() {
        return chapId;
    }

    public void setChapId(long chapId) {
        this.chapId = chapId;
    }

    @Basic
    @Column(name = "CHAP_TITLE_ID", nullable = true, length = 50)
    public Long getChapTitleId() {
        return chapTitleId;
    }

    public void setChapTitleId(Long chapTitleId) {
        this.chapTitleId = chapTitleId;
    }

    @Basic
    @Column(name = "CHAP_TITLE_NAME", nullable = true, length = 50)
    public String getChapTitleName() {
        return chapTitleName;
    }

    public void setChapTitleName(String chapTitleName) {
        this.chapTitleName = chapTitleName;
    }

    @Basic
    @Type(type = "text")
    @Column(name = "CHAP_CONTENT", nullable = true)
    public String getChapContent() {
        return chapContent;
    }

    public void setChapContent(String chapContent) {
        this.chapContent = chapContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chapter chapter = (Chapter) o;

        if (chapId != chapter.chapId) return false;
        if (chapTitleId != null ? !chapTitleId.equals(chapter.chapTitleId) : chapter.chapTitleId != null) return false;
        if (chapTitleName != null ? !chapTitleName.equals(chapter.chapTitleName) : chapter.chapTitleName != null)
            return false;
        if (chapContent != null ? !chapContent.equals(chapter.chapContent) : chapter.chapContent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (chapId ^ (chapId >>> 32));
        result = 31 * result + (chapTitleId != null ? chapTitleId.hashCode() : 0);
        result = 31 * result + (chapTitleName != null ? chapTitleName.hashCode() : 0);
        result = 31 * result + (chapContent != null ? chapContent.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "BOOK_ID", referencedColumnName = "BOOK_ID")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
