package com.yx.po;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "BIG_CATEGORY", schema = "MYACCOUNT", catalog = "")
public class BigCategory implements Serializable {
    private long bigCateId;
    private String bigCateName;
    private Set<com.yx.po.SmallCategory> SmallCategory;

    @Id
    @Column(name = "BIG_CATE_ID", nullable = false, precision = 0)
    public long getBigCateId() {
        return bigCateId;
    }

    public void setBigCateId(long bigCateId) {
        this.bigCateId = bigCateId;
    }

    @Basic
    @Column(name = "BIG_CATE_NAME", nullable = true, length = 50)
    public String getBigCateName() {
        return bigCateName;
    }

    public void setBigCateName(String bigCateName) {
        this.bigCateName = bigCateName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BigCategory that = (BigCategory) o;

        if (bigCateId != that.bigCateId) return false;
        if (bigCateName != null ? !bigCateName.equals(that.bigCateName) : that.bigCateName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (bigCateId ^ (bigCateId >>> 32));
        result = 31 * result + (bigCateName != null ? bigCateName.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "bigCategory")
    public Set<com.yx.po.SmallCategory> getSmallCategory() {
        return SmallCategory;
    }

    public void setSmallCategory(Set<com.yx.po.SmallCategory> smallCategory) {
        SmallCategory = smallCategory;
    }
}
