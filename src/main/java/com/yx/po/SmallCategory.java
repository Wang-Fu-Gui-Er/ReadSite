package com.yx.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "SMALL_CATEGORY", schema = "MYACCOUNT")//, catalog = ""
public class SmallCategory implements Serializable {
    private long smallCateId;
    private String smallCateName;
    private com.yx.po.BigCategory BigCategory;
    private Set<Book> book;

    @Id
    @Column(name = "SMALL_CATE_ID", nullable = false, precision = 0)
    public long getSmallCateId() {
        return smallCateId;
    }

    public void setSmallCateId(long smallCateId) {
        this.smallCateId = smallCateId;
    }

    @Basic
    @Column(name = "SMALL_CATE_NAME", nullable = true, length = 50)
    public String getSmallCateName() {
        return smallCateName;
    }

    public void setSmallCateName(String smallCateName) {
        this.smallCateName = smallCateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmallCategory that = (SmallCategory) o;

        if (smallCateId != that.smallCateId) return false;
        if (smallCateName != null ? !smallCateName.equals(that.smallCateName) : that.smallCateName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (smallCateId ^ (smallCateId >>> 32));
        result = 31 * result + (smallCateName != null ? smallCateName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "BIG_CATE_ID", referencedColumnName = "BIG_CATE_ID")
    public com.yx.po.BigCategory getBigCategory() {
        return BigCategory;
    }

    public void setBigCategory(com.yx.po.BigCategory bigCategory) {
        BigCategory = bigCategory;
    }

    @OneToMany(mappedBy = "smallCategory")
    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }
}
