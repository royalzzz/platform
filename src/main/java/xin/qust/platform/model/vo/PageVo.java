package xin.qust.platform.model.vo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageVo implements Pageable {

    int pageNumber;
    int pageSize;

    PageVo(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @Override
    public long getOffset() {
        return (long)this.pageNumber * (long)this.pageSize;
    }

    @Override
    public Sort getSort() {
        return Sort.unsorted();
    }

    @Override
    public Pageable next() {
        return new PageVo(this.getPageNumber() + 1, this.getPageSize());
    }

    @Override
    public Pageable previousOrFirst() {
        return this.getPageNumber() == 0 ? this : new PageVo(this.getPageNumber() - 1, this.getPageSize());
    }

    @Override
    public Pageable first() {
        return new PageVo(0, this.getPageSize());
    }

    @Override
    public boolean hasPrevious() {
        return this.getPageNumber() >= 0;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
