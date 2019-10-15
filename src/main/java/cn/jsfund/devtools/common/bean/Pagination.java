package cn.jsfund.devtools.common.bean;

/**
 * Created by hutx on 15:36 2018/11/26
 */
public class Pagination {
    private long total;
    private long pageSize;
    private long current;

    public Pagination() {
    }

    public Pagination(long current, long pageSize, long total) {
        this.current = current;
        this.pageSize = pageSize;
        this.total = total;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
}
