package com.yx.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Author implements Serializable{
    private long authorId;
    private String authorName;
    private String authorDescribe;
    private String authorPic;
    private Set<Book> book;

    @Id
    @Column(name = "AUTHOR_ID", nullable = false, precision = 0)
    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }

    @Basic
    @Column(name = "AUTHOR_NAME", nullable = true, length = 20)
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Basic
    @Column(name = "AUTHOR_DESCRIBE", nullable = true, length = 4000)
    public String getAuthorDescribe() {
        return authorDescribe;
    }

    public void setAuthorDescribe(String authorDescribe) {
        this.authorDescribe = authorDescribe;
    }

    @Basic
    @Column(name = "AUTHOR_PIC", nullable = true, length = 100)
    public String getAuthorPic() {
        return authorPic;
    }

    public void setAuthorPic(String authorPic) {
        this.authorPic = authorPic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (authorId != author.authorId) return false;
        if (authorName != null ? !authorName.equals(author.authorName) : author.authorName != null) return false;
        if (authorDescribe != null ? !authorDescribe.equals(author.authorDescribe) : author.authorDescribe != null)
            return false;
        if (authorPic != null ? !authorPic.equals(author.authorPic) : author.authorPic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (authorId ^ (authorId >>> 32));
        result = 31 * result + (authorName != null ? authorName.hashCode() : 0);
        result = 31 * result + (authorDescribe != null ? authorDescribe.hashCode() : 0);
        result = 31 * result + (authorPic != null ? authorPic.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "author")
    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }
}
