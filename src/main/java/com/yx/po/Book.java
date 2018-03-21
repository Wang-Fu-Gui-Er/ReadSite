package com.yx.po;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Set;

@Entity
public class Book implements Serializable {
    private long bookId;
    private String bookName;
    private Long bookDate;
    private String bookDescribe;
    private String bookPic;
    private Long bookReadCount;
    private Long bookDownloadCount;
    private String bookContent;
    private Long bookOut;
    private Long chapCount;
    private Author author;
    private SmallCategory smallCategory;
    private Set<Chapter> chapter;

    @Id
    @Column(name = "BOOK_ID", nullable = false, precision = 0)
    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    @Basic
    @Column(name = "BOOK_NAME", nullable = true, length = 100)
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Basic
    @Column(name = "BOOK_DATE", nullable = true)
    public Long getBookDate() {
        return bookDate;
    }

    public void setBookDate(Long bookDate) {
        this.bookDate = bookDate;
    }

    @Basic
    @Column(name = "BOOK_DESCRIBE", nullable = true, length = 4000)
    public String getBookDescribe() {
        return bookDescribe;
    }

    public void setBookDescribe(String bookDescribe) {
        this.bookDescribe = bookDescribe;
    }

    @Basic
    @Column(name = "BOOK_PIC", nullable = true, length = 100)
    public String getBookPic() {
        return bookPic;
    }

    public void setBookPic(String bookPic) {
        this.bookPic = bookPic;
    }

    @Basic
    @Column(name = "BOOK_READ_COUNT", nullable = true, precision = 0)
    public Long getBookReadCount() {
        return bookReadCount;
    }

    public void setBookReadCount(Long bookReadCount) {
        this.bookReadCount = bookReadCount;
    }

    @Basic
    @Column(name = "BOOK_DOWNLOAD_COUNT", nullable = true, precision = 0)
    public Long getBookDownloadCount() {
        return bookDownloadCount;
    }

    public void setBookDownloadCount(Long bookDownloadCount) {
        this.bookDownloadCount = bookDownloadCount;
    }

    @Basic
    @Column(name = "BOOK_CONTENT", nullable = true)
    public String getBookContent() {
        return bookContent;
    }

    public void setBookContent(String bookContent) {
        this.bookContent = bookContent;
    }

    @Basic
    @Column(name = "BOOK_OUT", nullable = true, precision = 0)
    public Long getBookOut() {
        return bookOut;
    }

    public void setBookOut(Long bookOut) {
        this.bookOut = bookOut;
    }

    @Basic
    @Column(name = "CHAP_COUNT", nullable = true, precision = 0)
    public Long getChapCount() {
        return chapCount;
    }

    public void setChapCount(Long chapCount) {
        this.chapCount = chapCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookId != book.bookId) return false;
        if (bookName != null ? !bookName.equals(book.bookName) : book.bookName != null) return false;
        if (bookDate != null ? !bookDate.equals(book.bookDate) : book.bookDate != null) return false;
        if (bookDescribe != null ? !bookDescribe.equals(book.bookDescribe) : book.bookDescribe != null) return false;
        if (bookPic != null ? !bookPic.equals(book.bookPic) : book.bookPic != null) return false;
        if (bookReadCount != null ? !bookReadCount.equals(book.bookReadCount) : book.bookReadCount != null)
            return false;
        if (bookDownloadCount != null ? !bookDownloadCount.equals(book.bookDownloadCount) : book.bookDownloadCount != null)
            return false;
        if (bookContent != null ? !bookContent.equals(book.bookContent) : book.bookContent != null) return false;
        if (bookOut != null ? !bookOut.equals(book.bookOut) : book.bookOut != null) return false;
        if (chapCount != null ? !chapCount.equals(book.chapCount) : book.chapCount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (bookId ^ (bookId >>> 32));
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (bookDate != null ? bookDate.hashCode() : 0);
        result = 31 * result + (bookDescribe != null ? bookDescribe.hashCode() : 0);
        result = 31 * result + (bookPic != null ? bookPic.hashCode() : 0);
        result = 31 * result + (bookReadCount != null ? bookReadCount.hashCode() : 0);
        result = 31 * result + (bookDownloadCount != null ? bookDownloadCount.hashCode() : 0);
        result = 31 * result + (bookContent != null ? bookContent.hashCode() : 0);
        result = 31 * result + (bookOut != null ? bookOut.hashCode() : 0);
        result = 31 * result + (chapCount != null ? chapCount.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID", referencedColumnName = "AUTHOR_ID")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToOne
    @JoinColumn(name = "SMALL_CATE_ID", referencedColumnName = "SMALL_CATE_ID")
    public SmallCategory getSmallCategory() {
        return smallCategory;
    }

    public void setSmallCategory(SmallCategory smallCategory) {
        this.smallCategory = smallCategory;
    }

    @OneToMany(mappedBy = "book")
    public Set<Chapter> getChapter() {
        return chapter;
    }

    public void setChapter(Set<Chapter> chapter) {
        this.chapter = chapter;
    }
}
